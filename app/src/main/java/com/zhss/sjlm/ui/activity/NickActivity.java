package com.zhss.sjlm.ui.activity;

import com.zhss.sjlm.R;
import com.zhss.sjlm.base.BaseActivity;

/**
 * Created by win7-64 on 2018/3/7.
 */

 public class NickActivity  extends BaseActivity{
    @Override
    public void setContentLayout(int resid) {
        super.setContentLayout(R.layout.activity_nicheng);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
         tvCenter.setText("修改昵称");
    }
}
