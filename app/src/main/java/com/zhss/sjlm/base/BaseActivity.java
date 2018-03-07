package com.zhss.sjlm.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhss.sjlm.MyApplication;
import com.zhss.sjlm.R;
import com.zhss.sjlm.tools.StatusBarUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by win7-64 on 2018/2/27.
 */


public abstract class BaseActivity extends Activity {
    @BindView(R.id.iv_left)
    LinearLayout ivLeft;
    @BindView(R.id.tv_center)
    public TextView tvCenter;
    @BindView(R.id.tv_right)
    public TextView tvRight;
    @BindView(R.id.l_share)
    LinearLayout lShare;
    @BindView(R.id.rl_base_title)
    public RelativeLayout rlBaseTitle;
    @BindView(R.id.fl_base_activity)
    FrameLayout flBaseActivity;
    private Unbinder mUnbinder;


    protected MyApplication mApplication;

    protected CompositeDisposable disposables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.base_activity);
        StatusBarUtils.setColor(this, getResources().getColor(R.color.statusBarColor));
        initStatusLayout();

        //ButterKnife 的绑定
        mUnbinder = ButterKnife.bind(this);
        this.mApplication = (MyApplication) getApplication();
        initView();
        initData();
    }

    public void setContentLayout(int resid) {

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(resid, null);
        flBaseActivity.addView(contentView);
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
