package com.zhss.sjlm.ui.contact;

import com.zhss.sjlm.bean.CategreyBean;
import com.zhss.sjlm.present.BasePresenter;
import com.zhss.sjlm.ui.BaseView;

import java.util.List;

/**
 * Created by win7-64 on 2018/3/1.
 */

public interface ClassfyContact {
    interface view extends BaseView {
        /**
         * 设置数据
         *
         * @param dataList
         */
        void setData(List<CategreyBean> dataList);
    }

    interface ClassfyPresent extends BasePresenter {
        void getData();
    }
}
