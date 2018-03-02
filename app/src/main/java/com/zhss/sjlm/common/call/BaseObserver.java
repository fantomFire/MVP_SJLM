package com.zhss.sjlm.common.call;

import android.content.Context;
import android.net.ParseException;
import android.support.annotation.CallSuper;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zhss.sjlm.bean.BaseResult;

import org.json.JSONException;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * Created by win7-64 on 2018/2/28.
 */

public abstract class BaseObserver<T>  implements Observer<BaseResult<T>> {
    private final String RESPONSE_CODE_OK = "200";       //自定义的业务逻辑，成功返回积极数据
    private final String RESPONSE_CODE_FAILED = "400";  //返回数据失败,严重的错误
    private Context mContext;
    private static Gson gson = new Gson();
    private String errorCode;
    private String errorMsg = "未知的错误！";
    private Disposable disposable;

    public abstract void onSuccess(T t);

    @Override
    public void onSubscribe(Disposable d) {
        disposable =d;
    }
    public  BaseObserver(Context mContext) {
        this.mContext = mContext;
        HttpUiTips.showDialog(mContext, null);
    }

    @Override
    public void onNext(BaseResult<T> response) {
        HttpUiTips.dismissDialog(mContext);
        if(!disposable.isDisposed()){
            disposable.dispose();
        }

        if (response.getStatus().equals(RESPONSE_CODE_OK) ) {
            onSuccess(response.getData());
        } else {
            onFailure(response.getStatus(), response.getMsg());
        }


    }
    /**
     * Default error dispose!
     * 一般的就是 AlertDialog 或 SnackBar
     *
     * @param code
     * @param message
     */
    @CallSuper  //if overwrite,you should let it run.
    public void onFailure(String code, String message) {
        disposeEorCode(message, code);
        /*System.out.println("错误mcontext"+mContext);
        if (code.equals(RESPONSE_CODE_FAILED)  && mContext != null) {
           // HttpUiTips.alertTip(mContext, message, code);
        } else {
            disposeEorCode(message, code);
        }*/
    }

    /**
     * 对通用问题的统一拦截处理
     * @param code
     */
    private final void disposeEorCode(String message, String code) {
        Toast.makeText(mContext, message , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(Throwable e) {
        System.out.println("3332422234234"+e);
        HttpUiTips.dismissDialog(mContext);
        e.printStackTrace();
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            errorCode = httpException.code()+"";
            errorMsg = httpException.getMessage();
            getErrorMsg(httpException);
        } else if (e instanceof SocketTimeoutException) {  //VPN open
            errorCode = RESPONSE_CODE_FAILED;
            errorMsg = "网络连接异常";
        }else if (e instanceof ConnectException) { //均视为网络错误
            errorCode = RESPONSE_CODE_FAILED;
            errorMsg = "网络连接异常";
        } else if (e instanceof JSONException
                || e instanceof JSONException
                || e instanceof ParseException) {   //均视为解析错误
            errorCode = RESPONSE_CODE_FAILED;

            errorMsg = "数据解析异常";
        }else if (e instanceof UnknownHostException) {
            errorCode = RESPONSE_CODE_FAILED;
            errorMsg = "网络连接异常";
        }
        System.out.println("errorCode"+errorCode+"errorMsg"+errorMsg);
        onFailure(errorCode, errorMsg);
    }

    @Override
    public void onComplete() {
        HttpUiTips.dismissDialog(mContext);
    }
    /**
     * 获取详细的错误的信息 errorCode,errorMsg ,   这里和Api 结构有关，这里和Api 结构有关 ！
     * 以登录的时候的Grant_type 故意写错为例子,http 应该是直接的返回401=httpException.code()
     * 但是是怎么导致401的？我们的服务器会在respose.errorBody 中的content 中说明
     */
    private final void getErrorMsg(HttpException httpException) {
        System.out.println("httpException"+httpException);
        String errorBodyStr = "";
        try {   //我们的项目需要的UniCode转码，不是必须要的！
            errorBodyStr = TextConvertUtils.convertUnicode(httpException.response().errorBody().string());
        } catch (IOException ioe) {
        }

        try {
            BaseResult errorResponse = gson.fromJson(errorBodyStr, BaseResult.class);
            if (null != errorResponse) {
                errorCode = errorResponse.getStatus();
                errorMsg = errorResponse.getMsg();
            } else {
                errorCode = RESPONSE_CODE_FAILED;
                errorMsg = "ErrorResponse is null";
            }
        } catch (Exception jsonException) {
            errorCode = RESPONSE_CODE_FAILED;
            errorMsg = "http请求错误Json 信息异常";
            jsonException.printStackTrace();
        }
    }

}
