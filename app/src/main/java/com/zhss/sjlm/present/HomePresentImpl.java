package com.zhss.sjlm.present;

import com.zhss.sjlm.ui.contact.HomeContact;

/**
 * Created by win7-64 on 2018/3/1.
 */

public class HomePresentImpl  extends BasePresentipl<HomeContact.view>implements HomeContact.HomePresent{
    public HomePresentImpl(HomeContact.view view) {
        super(view);
    }

    @Override
    public void getData() {
       /* RetrofitClient.getInstance(mContext).provideApiService().getHomeData()
                .compose(RxSchedulerHepler.io_main())*/

    }
}
