package com.zhss.sjlm.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zhss.sjlm.R;
import com.zhss.sjlm.present.BasePresenter;
import com.zhss.sjlm.tools.StatusBarUtils;
import com.zhss.sjlm.ui.BaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseMvpActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView{

   protected P mPresenter;
    private Unbinder mUnbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(getLayoutId());
        StatusBarUtils.setColor(this, getResources().getColor(R.color.statusBarColor));

        initStatusLayout();
        mUnbinder = ButterKnife.bind(this);

        mPresenter = createPresenter();

        initData();
    }
    /**
     * 子类如果需要多状态布局，需要重写此方法来配置多状态布局
     * 子类需要执行两部操作
     * Step1 初始化StatusLayout 配置多状态布局
     * Step2 添加到 ContentView的相应位置中
     */
    private void initStatusLayout() {

    }

    protected abstract int getLayoutId();


    protected abstract void initData();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detach();
            mPresenter = null;
        }
        if(mUnbinder!=null) {
            mUnbinder.unbind();
            mUnbinder = null;
        }
    }

    /*
   * Activity的跳转，太简单了
   *
   */
    public final void startActivity(Class<?> cla) {
        Intent intent = new Intent();
        intent.setClass(this, cla);
        startActivity(intent);
    }



    /**
     * 创建 Presenter
     *
     * @return
     */
    public abstract P createPresenter();

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void showErrorMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
