package com.zhss.sjlm.present;

import android.text.TextUtils;

import com.zhss.sjlm.bean.BaseResult;
import com.zhss.sjlm.bean.LoginBean;
import com.zhss.sjlm.call.BaseObserver;
import com.zhss.sjlm.common.http.RetrofitClient;
import com.zhss.sjlm.rxHelper.RxSchedulerHepler;
import com.zhss.sjlm.ui.contact.LoginContact;

/**
 * Created by win7-64 on 2018/2/27.
 */

public class LongPresent extends BasePresentipl<LoginContact.view> implements LoginContact.LoginPren {
    public LongPresent(LoginContact.view view) {
        super(view);
    }


    @Override
    public void getData(String mPhone, String mPass) {
        if (TextUtils.isEmpty(mPhone)) {
            view.showErrorMsg("请输入手机号码");
            return;
        }
        if (TextUtils.isEmpty(mPass)) {
            view.showErrorMsg("请输入密码");
            return;
        }
        view.showLoading();
        RetrofitClient.getInstance(mContext).provideApiService().loading(mPhone, mPass)
                .compose(RxSchedulerHepler.<BaseResult<LoginBean>>io_main())
                .doOnSubscribe(disposable ->
                        addDisposable(disposable)
                )

                .subscribe(new BaseObserver<LoginBean>(mContext) {
                               @Override
                               public void onSuccess(LoginBean loginBean) {
                                   System.out.println("成功" + loginBean.toString());
                                   view.setData(loginBean);
                               }

                           }
                );

    }
}
