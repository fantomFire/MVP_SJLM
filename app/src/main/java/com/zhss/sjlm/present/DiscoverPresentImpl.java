package com.zhss.sjlm.present;

import com.zhss.sjlm.bean.DiscoverTitleBean;
import com.zhss.sjlm.common.RxSchedulerHepler;
import com.zhss.sjlm.common.call.BaseObserver;
import com.zhss.sjlm.ui.contact.DiscoverContact;

import java.util.List;

/**
 * Created by win7-64 on 2018/3/2.
 */

public class DiscoverPresentImpl extends BasePresentipl<DiscoverContact.view> implements DiscoverContact.DiscoverPresent{
    public DiscoverPresentImpl(DiscoverContact.view view) {
        super(view);
    }

    @Override
    public void getData() {

    }

    @Override
    public void getTitle() {
      apiService.getDiscoverTitle()
               .compose(RxSchedulerHepler.io_main())
                .doOnSubscribe(disposable -> addDisposable(disposable))
                .subscribe(new BaseObserver<List<DiscoverTitleBean>>(mContext) {
                    @Override
                    public void onSuccess(List<DiscoverTitleBean> discoverTitleBeans) {
                            view.setData(discoverTitleBeans);
                    }
                });
    }
}
