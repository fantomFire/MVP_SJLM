package com.zhss.sjlm.ui.contact;

import com.zhss.sjlm.bean.DiscoverTitleBean;
import com.zhss.sjlm.present.BasePresenter;
import com.zhss.sjlm.ui.BaseView;

import java.util.List;

/**
 * Created by win7-64 on 2018/3/2.
 */

public interface DiscoverContact {
    interface view extends BaseView {

        void setData(List<DiscoverTitleBean> data);
    }

    interface DiscoverPresent extends BasePresenter {

        void getData();

        void getTitle();
    }

}
