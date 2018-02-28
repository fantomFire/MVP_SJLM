package com.zhss.sjlm.ui;

/**
 * Created by win7-64 on 2018/2/27.
 */

public interface BaseView {
    void showLoading();
    void dismissLoading();
    void showErrorMsg(String msg);
}
