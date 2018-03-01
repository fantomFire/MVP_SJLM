package com.zhss.sjlm.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.zhss.sjlm.MyApplication;
import com.zhss.sjlm.R;
import com.zhss.sjlm.tools.StatusBarUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by win7-64 on 2018/2/27.
 */


public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder mUnbinder;


    protected MyApplication mApplication;

    protected CompositeDisposable disposables;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(getLayoutId());
        StatusBarUtils.setColor(this, getResources().getColor(R.color.statusBarColor));
        initStatusLayout();

        //ButterKnife 的绑定
        mUnbinder = ButterKnife.bind(this);
        this.mApplication = (MyApplication) getApplication();
        initView();
        initData();
    }

    protected abstract void initData();

    /**
     * 子类如果需要多状态布局，需要重写此方法来配置多状态布局
     * 子类需要执行两部操作
     * Step1 初始化StatusLayout 配置多状态布局
     * Step2 添加到 ContentView的相应位置中
     */
    public void initStatusLayout() {
    }


    /**
     * 初始化操作
     */
    protected abstract void initView();

    /**
     * 子类需要提供布局ID
     *
     * @return activity对应的  布局id
     */
    protected abstract int getLayoutId();


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

    public void addRx(Disposable disposable) {
        if (disposables == null) {
            disposables = new CompositeDisposable();
        }
        disposables.add(disposable);
    }

    public void removeRx(Disposable disposable) {
        if (disposables == null) {
            return;
        }
        disposables.remove(disposable);

    }
}
