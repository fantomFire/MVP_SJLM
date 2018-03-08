package com.zhss.sjlm.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.zhss.sjlm.MyApplication;
import com.zhss.sjlm.R;
import com.zhss.sjlm.common.ApiService;
import com.zhss.sjlm.common.http.RetrofitClient;
import com.zhss.sjlm.tools.StatusBarUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by win7-64 on 2018/2/27.
 */


public abstract class BaseActivity extends Activity {
    private Unbinder mUnbinder;

    public Activity mActivity;
    protected MyApplication mApplication;

    protected CompositeDisposable disposables;
    public ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getlayoutId());
        StatusBarUtils.setColor(this, getResources().getColor(R.color.statusBarColor));

        //ButterKnife 的绑定
        mUnbinder = ButterKnife.bind(this);
        this.mActivity = this;
        this.mApplication = (MyApplication) getApplication();
        apiService = RetrofitClient.getInstance(mApplication).provideApiService();
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getlayoutId();


    /**
     * 初始化操作
     */


    /**
     * 子类需要提供布局ID
     *
     * @return activity对应的  布局id
     */
    public void startActivity(Class<? extends Activity> clazz) {
        startActivity(new Intent(this, clazz));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (disposables != null) {
            disposables.dispose();
            disposables = null;
        }

        if (mUnbinder != null) {
            mUnbinder.unbind();
            mUnbinder = null;
        }
    }
    @OnClick(R.id.iv_left)
    public void onViewClicked() {
        finish();
    }
}
