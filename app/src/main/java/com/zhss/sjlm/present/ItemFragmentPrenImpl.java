package com.zhss.sjlm.present;

import com.zhss.sjlm.bean.DiscoverBean;
import com.zhss.sjlm.common.RxSchedulerHepler;
import com.zhss.sjlm.common.call.BaseObserver;
import com.zhss.sjlm.ui.contact.DiscoverItemContact;

import java.util.List;

/**
 * Created by win7-64 on 2018/3/2.
 */

public class ItemFragmentPrenImpl extends BasePresentipl<DiscoverItemContact.view> implements DiscoverItemContact.DiscoverItemPresent {

    public ItemFragmentPrenImpl(DiscoverItemContact.view view) {
        super(view);
    }

    @Override
    public void getData(int findid) {
        apiService.getItemData(findid)
                .compose(RxSchedulerHepler.io_main())
                .doOnSubscribe(disposable -> addDisposable(disposable))
                .subscribe(new BaseObserver<List<DiscoverBean>>(mContext) {
                    @Override
                    public void onSuccess(List<DiscoverBean> discoverBeans) {
                        view.setData(discoverBeans);
                    }
                });
    }
}
