package com.zhss.sjlm.ui.contact;

import com.zhss.sjlm.bean.DiscoverBean;
import com.zhss.sjlm.present.BasePresenter;
import com.zhss.sjlm.ui.BaseView;

import java.util.List;

/**
 * Created by win7-64 on 2018/3/2.
 */

public interface DiscoverItemContact {
    interface view extends BaseView {
        /**
         * 设置数据
         *
         * @param dataList
         */
        void setData(List<DiscoverBean> discoverBeans);
    }

    interface DiscoverItemPresent extends BasePresenter {
        /**
         * 获取数据
         * @param s
         * @param toString
         * @param findid
         */
        void getData(int findid);
    }

}
