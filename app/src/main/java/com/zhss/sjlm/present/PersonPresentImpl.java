package com.zhss.sjlm.present;

import com.zhss.sjlm.bean.MineInfoBean;
import com.zhss.sjlm.common.RxSchedulerHepler;
import com.zhss.sjlm.common.call.BaseObserver;
import com.zhss.sjlm.ui.contact.PersonContact;

/**
 * Created by win7-64 on 2018/3/7.
 */

public class PersonPresentImpl extends BasePresentipl<PersonContact.View> implements PersonContact.PersonPre {
    public PersonPresentImpl(PersonContact.View view) {
        super(view);
    }

    @Override
    public void getData(String user_id) {
            apiService.getUserInfo(user_id)
                    .compose(RxSchedulerHepler.io_main())
                    .doOnSubscribe(disposable -> addDisposable(disposable))
                   .subscribe(new BaseObserver<MineInfoBean.DataBean>(mContext) {
                       @Override
                       public void onSuccess(MineInfoBean.DataBean dataBean) {
                           view.setData(dataBean);
                       }
                   });
    }
}
