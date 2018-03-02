package com.zhss.sjlm.present;

import com.zhss.sjlm.bean.DiscoverTitleBean;
import com.zhss.sjlm.common.RxSchedulerHepler;
import com.zhss.sjlm.common.call.BaseObserver;
import com.zhss.sjlm.ui.contact.HomeContact;

import java.util.List;

/**
 * Created by win7-64 on 2018/3/1.
 */

public class HomePresentImpl  extends BasePresentipl<HomeContact.view>implements HomeContact.HomePresent{
    public HomePresentImpl(HomeContact.view view) {
        super(view);
    }

    @Override
    public void getData() {
     apiService.getDiscoverTitle()
             .compose(RxSchedulerHepler.io_main())
             .subscribe(new BaseObserver<List<DiscoverTitleBean>>(mContext) {
                 @Override
                 public void onSuccess(List<DiscoverTitleBean> discoverTitleBeans) {
                     System.out.println("返回结果"+discoverTitleBeans.size());
                 }
             });

    }
}
