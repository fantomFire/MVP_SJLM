package com.zhss.sjlm.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zhss.sjlm.MyApplication;
import com.zhss.sjlm.present.BasePresentipl;
import com.zhss.sjlm.ui.BaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;


public abstract class BaseMvpFragment <P  extends BasePresentipl> extends Fragment implements BaseView {


    private boolean mIsVisible = false;     // fragment是否显示了

    private boolean isPrepared = false;

    private boolean isFirst = true; //只加载一次界面
    protected  P mPresenter;

    protected Activity mActivity;

    protected MyApplication mApplication;

    protected View mRootView;

    protected Unbinder mUnbinder;

    protected CompositeDisposable disposables;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutId(),container,false);
        mUnbinder = ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    protected abstract int getLayoutId();
    public void startActivity(Class<? extends Activity> clazz){
        mActivity.startActivity(new Intent(mActivity,clazz));
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter = createPresenter();
        isPrepared=true;

        mApplication = (MyApplication) mActivity.getApplication();
        initView();
        initData();

    }

    protected abstract void initView();

 /*   @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (!isPrepared) {
            return;
        }
        if(getUserVisibleHint()){
            mIsVisible = true;
            initData();

        } else {//fragment不可见
            mIsVisible = false;
        }
    }
*/

    protected abstract void initData();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(mPresenter!=null) {
            mPresenter.detach();
            mPresenter = null;
        }
        if (disposables != null) {
            disposables.dispose();
            disposables = null;
        }
        if (mUnbinder != null) {
            mUnbinder.unbind();
            mUnbinder = null;
        }

    }


    /**
     * 创建 Presenter
     * @return
     */
    public  abstract  P createPresenter() ;

    @Override
    public void showErrorMsg(String msg) {
        Toast.makeText(mActivity, msg, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }
}
