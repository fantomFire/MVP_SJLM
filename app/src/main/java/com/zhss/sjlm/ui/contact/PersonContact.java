package com.zhss.sjlm.ui.contact;

import com.zhss.sjlm.bean.MineInfoBean;
import com.zhss.sjlm.present.BasePresenter;
import com.zhss.sjlm.ui.BaseView;

import java.util.ArrayList;

/**
 * Created by win7-64 on 2018/3/7.
 */

public interface PersonContact {
    interface View extends BaseView {
        /**
         * 设置数据
         *
         * @param dataList
         */
        void setData(MineInfoBean.DataBean dataList);
    }

    interface PersonPre extends BasePresenter {
        void getData(String user_id);
        void  upDataPhoto(String user_id, ArrayList<String> imgStr);
    }
}
