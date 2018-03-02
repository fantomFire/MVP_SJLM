package com.zhss.sjlm.present;

import com.zhss.sjlm.bean.CategreyBean;
import com.zhss.sjlm.common.call.BaseObserver;
import com.zhss.sjlm.common.RxSchedulerHepler;
import com.zhss.sjlm.ui.contact.ClassfyContact;

import java.util.List;

/**
 * Created by win7-64 on 2018/3/1.
 */

public class ClassfyPresentImpl  extends BasePresentipl<ClassfyContact.view> implements ClassfyContact.ClassfyPresent {
    public ClassfyPresentImpl(ClassfyContact.view view) {
        super(view);
    }

    @Override
    public void getData() {
        apiService.getCateData().compose(RxSchedulerHepler.io_main())
                .doOnSubscribe(disposable -> addDisposable(disposable))
                .subscribe(new BaseObserver<List<CategreyBean>>(mContext) {
                    @Override
                    public void onSuccess(List<CategreyBean> categreyBean) {
                        view.setData(categreyBean);
                    }
                });
    }
}
