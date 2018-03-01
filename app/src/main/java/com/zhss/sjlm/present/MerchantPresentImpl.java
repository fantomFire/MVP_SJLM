package com.zhss.sjlm.present;

import com.zhss.sjlm.bean.CategreyBean;
import com.zhss.sjlm.call.BaseObserver;
import com.zhss.sjlm.rxHelper.RxSchedulerHepler;
import com.zhss.sjlm.ui.contact.MerchantContact;

import java.util.List;

/**
 * Created by win7-64 on 2018/3/1.
 */

public class MerchantPresentImpl extends BasePresentipl<MerchantContact.view>implements MerchantContact.MerchantPresent{
    public MerchantPresentImpl(MerchantContact.view view) {
        super(view);
    }

    @Override
    public void getMerchantData() {
        apiService.getCateData()
                .compose(RxSchedulerHepler.io_main())
                .doOnSubscribe(disposable -> addDisposable(disposable))
                .subscribe(new BaseObserver<List<CategreyBean>>(mContext) {
                    @Override
                    public void onSuccess(List<CategreyBean> categreyBeans) {
                        view.setData(categreyBeans);
                    }
                });

    }
}
