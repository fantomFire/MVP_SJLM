package com.zhss.sjlm.common.call;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.zhss.sjlm.bean.BaseResult;

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
      //  System.out.println("response"+response.toString());
        HttpUiTips.dismissDialog(mContext);
        if(!disposable.isDisposed()){
            disposable.dispose();
        }

        if (response.getStatus().equals(RESPONSE_CODE_OK) ) {
            onSuccess(response.getData());
        } else {

            onFailure( response.getMsg());
        }


    }
    /**
     * Default error dispose!
     * 一般的就是 AlertDialog 或 SnackBar
     *
     * @param
     * @param message
     */
    @CallSuper  //if overwrite,you should let it run.
    public void onFailure( String message) {
        Toast.makeText(mContext, message , Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onError(Throwable t) {
        HttpUiTips.dismissDialog(mContext);
        t.printStackTrace();
        String ERROR_MSG;
        if (t instanceof SocketTimeoutException) {
            ERROR_MSG = "服务器响应超时，稍后重试";
        } else if (t instanceof ConnectException) {
            ERROR_MSG = "网络连接异常，稍后重试";
        } else if (t instanceof UnknownHostException) {
            ERROR_MSG = "网络错误，稍后重试";
        } else if(t instanceof JsonParseException){
            ERROR_MSG = "数据解析出错";
        }else if(t instanceof HttpException){
            ERROR_MSG = "服务器异常,请稍后重试";
        }else if(t instanceof JsonParseException){
            ERROR_MSG = "数据解析出错";
        }else {
            ERROR_MSG = "未知异常";
        }
        onFailure(ERROR_MSG);
    }

    @Override
    public void onComplete() {
        HttpUiTips.dismissDialog(mContext);
    }


}
