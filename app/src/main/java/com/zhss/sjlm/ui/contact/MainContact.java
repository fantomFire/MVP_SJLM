package com.zhss.sjlm.ui.contact;

import com.zhss.sjlm.bean.LoginBean;
import com.zhss.sjlm.bean.MineInfoBean;
import com.zhss.sjlm.present.BasePresenter;
import com.zhss.sjlm.ui.BaseView;

/**
 * Created by win7-64 on 2018/3/7.
 */

public interface MainContact {
    interface view extends BaseView {
        /**
         * 设置数据
         *
         * @param dataList
         */
        void setData(MineInfoBean.DataBean dataList);
    }

    interface MainPresent extends BasePresenter {
        /**
         * 获取数据
         * @param s
         * @param toString
         * @param user_id
         */
        void getUserInfo(String user_id);
    }
}
