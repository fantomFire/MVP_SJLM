package com.zhss.sjlm.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zhss.sjlm.present.BasePresentipl;


public abstract class BaseMvpFragment <P  extends BasePresentipl> extends BaseFragment {


    protected  P mPresenter;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter = createPresenter();
        initData();
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

}
