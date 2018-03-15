package com.zhss.sjlm.present;

import com.zhss.sjlm.bean.AddressALLBean;
import com.zhss.sjlm.common.RxSchedulerHepler;
import com.zhss.sjlm.common.call.BaseObserver;
import com.zhss.sjlm.ui.contact.AddressContact;

/**
 * Created by win7-64 on 2018/3/14.
 */

public class AddressImpl extends BasePresentipl<AddressContact.view> implements AddressContact.AddPresent{
    public AddressImpl(AddressContact.view view) {
        super(view);
    }



    @Override
    public void getData(String user_id) {
        apiService.getAddress(user_id)
                .compose(RxSchedulerHepler.io_main())
                .doOnSubscribe(disposable -> addDisposable(disposable))
                .subscribe(new BaseObserver<AddressALLBean.DataBean>(mContext) {
                    @Override
                    public void onSuccess(AddressALLBean.DataBean addressBean) {
                            view.setData(addressBean);
                    }
                });
    }
    @Override
    public void delAddress(String del, String user_id, String address_id, int pos) {
        apiService.delAddress(del,user_id,address_id)
                .compose(RxSchedulerHepler.io_main())
                .doOnSubscribe(disposable -> addDisposable(disposable))
                .subscribe(new BaseObserver<Void>(mContext) {
                    @Override
                    public void onSuccess(Void aVoid) {
                       view.notifyChange(pos);
                    }
                });
    }
    //设置默认地址
    @Override
    public void setDefualtAddress(String user_id, String address_id) {
        apiService.delAddress("default",user_id,address_id)
                .compose(RxSchedulerHepler.io_main())
                .doOnSubscribe(disposable -> addDisposable(disposable))
                .subscribe(new BaseObserver<Void>(mContext) {
                    @Override
                    public void onSuccess(Void aVoid) {
                        view.setNewAddress();
                    }
                });
    }
}
