package com.zhss.sjlm.present;

import com.zhss.sjlm.bean.MineInfoBean;
import com.zhss.sjlm.common.RxSchedulerHepler;
import com.zhss.sjlm.common.call.BaseObserver;
import com.zhss.sjlm.ui.contact.MainContact;

/**
 * Created by win7-64 on 2018/3/7.
 */

public class MinePresentImpl extends BasePresentipl<MainContact.view> implements MainContact.MainPresent {
    public MinePresentImpl(MainContact.view view) {
        super(view);
    }



    @Override
    public void getUserInfo(String user_id) {
        apiService.getUserInfo(user_id)
                .compose(RxSchedulerHepler.io_main())
                .doOnSubscribe(disposable -> addDisposable(disposable))
                .subscribe(new BaseObserver<MineInfoBean.DataBean>(mContext) {
                    @Override
                    public void onSuccess(MineInfoBean.DataBean mineInfoBean) {
                        view.setData(mineInfoBean);
                    }
                });
    }
}
