package com.zhss.sjlm.present;

import com.zhss.sjlm.bean.DiscoverTitleBean;
import com.zhss.sjlm.common.http.RetrofitClient;
import com.zhss.sjlm.ui.contact.DiscoverContact;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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
        RetrofitClient.getInstance(mContext).provideApiService().getTitle()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DiscoverTitleBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DiscoverTitleBean listBaseResult) {
                        System.out.println("======================"+listBaseResult.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("结果错误");
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("请求完成");
                    }
                });
               /* .compose(RxSchedulerHepler.io_main())
                .doOnSubscribe(disposable -> addDisposable(disposable))
                .subscribe(new Observer<BaseResult<List<DiscoverTitleBean>>>() {
                               @Override
                               public void onSubscribe(Disposable d) {

                               }

                               @Override
                               public void onNext(BaseResult<List<DiscoverTitleBean>> listBaseResult) {
                                   System.out.println("返回结果"+listBaseResult.getData().size());
                               }

                               @Override
                               public void onError(Throwable e) {
                                    e.printStackTrace();
                               }

                               @Override
                               public void onComplete() {
                                   System.out.println("请求结束");
                               }
                           });


                        *//*new BaseObserver<List<DiscoverTitleBean>>(mContext) {
                    @Override
                    public void onSuccess(List<DiscoverTitleBean> discoverTitleBeans) {
                            view.setData(discoverTitleBeans);
                    }
                });*/
    }
}
