package com.zhss.sjlm.ui.contact;

import com.zhss.sjlm.bean.LoginBean;
import com.zhss.sjlm.present.BasePresenter;
import com.zhss.sjlm.ui.BaseView;

/**
 * Created by win7-64 on 2018/2/27.
 */

public interface LoginContact {

    interface view extends BaseView {
        /**
         * 设置数据
         *
         * @param dataList
         */
        void setData(LoginBean dataList);
    }

    interface LoginPren extends BasePresenter {
        /**
         * 获取数据
         * @param s
         * @param toString
         */
        void getData(String s, String toString);
    }
}
