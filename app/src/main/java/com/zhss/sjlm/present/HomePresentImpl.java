package com.zhss.sjlm.present;

import com.zhss.sjlm.bean.HomeDataBean;
import com.zhss.sjlm.common.RxSchedulerHepler;
import com.zhss.sjlm.common.call.BaseObserver;
import com.zhss.sjlm.ui.contact.HomeContact;

/**
 * Created by win7-64 on 2018/3/1.
 */

public class HomePresentImpl extends BasePresentipl<HomeContact.view> implements HomeContact.HomePresent {
    public HomePresentImpl(HomeContact.view view) {
        super(view);
    }

    @Override
    public void getData() {
        apiService.getHomeData()
                .compose(RxSchedulerHepler.io_main())
                .subscribe(new BaseObserver<HomeDataBean.DataBean>(mContext) {
                    @Override
                    public void onSuccess(HomeDataBean.DataBean homeDataBean) {
                        if (homeDataBean.getBanner() != null && homeDataBean.getBanner().size() > 0) {
                            view.setBanner(homeDataBean.getBanner());
                        }
                        if (homeDataBean.getPosition1() != null) {
                            view.setFood(homeDataBean.getPosition1());
                        }
                        if (homeDataBean.getPosition2() != null) {
                            view.setYiju(homeDataBean.getPosition2());
                        }
                        if (homeDataBean.getPosition3() != null) {
                            view.setSS(homeDataBean.getPosition3());
                        }

                    }
                });

    }
}
