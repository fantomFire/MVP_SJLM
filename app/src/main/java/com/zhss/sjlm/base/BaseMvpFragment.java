package com.zhss.sjlm.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zhss.sjlm.present.BasePresentipl;
import com.zhss.sjlm.ui.BaseView;


public abstract class BaseMvpFragment <P  extends BasePresentipl> extends BaseFragment implements BaseView {


    private boolean mIsVisible = false;     // fragment是否显示了

    private boolean isPrepared = false;

    private boolean isFirst = true; //只加载一次界面
    protected  P mPresenter;




    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter = createPresenter();

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(getUserVisibleHint()){
            mIsVisible = true;
            onVisible();
        } else {//fragment不可见
            mIsVisible = false;
            //onInvisible();
        }
    }
    protected void onVisible() {
       /* if (!mIsVisible || !isPrepared || !isFirst) {
            return;
        }*/
        initData();//根据获取的数据来调用showView()切换界面
    }

    protected abstract void initData();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(mPresenter!=null) {
            mPresenter.detach();
            mPresenter = null;
        }

    }


    /**
     * 创建 Presenter
     * @return
     */
    public  abstract  P createPresenter() ;

    @Override
    public void showErrorMsg(String msg) {


    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }
}
