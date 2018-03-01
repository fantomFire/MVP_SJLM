package com.zhss.sjlm.present;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.zhss.sjlm.common.ApiService;
import com.zhss.sjlm.common.http.RetrofitClient;
import com.zhss.sjlm.ui.BaseView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by win7-64 on 2018/2/27.
 */

public abstract class BasePresentipl<V extends BaseView> implements BasePresenter {

    protected V view;
    protected Context mContext;
    public ApiService apiService;

    public BasePresentipl(V view) {
        this.view = view;
        initContext(view);

        start();
    }

    protected void initContext(V view) {
        if (view instanceof Activity) {
            //Activity
            mContext = (Activity) view;
        } else {
            mContext = ((Fragment) view).getActivity();
        }
        apiService = RetrofitClient.getInstance(mContext).provideApiService();
    }

    @Override
    public void start() {

    }


    @Override
    public void detach() {
        this.view = null;
        unDisposable();
    }


    //将所有正在处理的Subscription都添加到CompositeSubscription中。统一退出的时候注销观察
    private CompositeDisposable mCompositeDisposable;

    /**
     * 将Disposable添加
     *
     * @param subscription
     */
    @Override
    public void addDisposable(Disposable subscription) {
        //csb 如果解绑了的话添加 sb 需要新的实例否则绑定时无效的
        if (mCompositeDisposable == null || mCompositeDisposable.isDisposed()) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(subscription);
    }

    /**
     * 在界面退出等需要解绑观察者的情况下调用此方法统一解绑，防止Rx造成的内存泄漏
     */
    @Override
    public void unDisposable() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
        }
    }
}
