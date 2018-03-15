package com.zhss.sjlm.ui.contact;

import com.zhss.sjlm.bean.AddressALLBean;
import com.zhss.sjlm.present.BasePresenter;
import com.zhss.sjlm.ui.BaseView;

/**
 * Created by win7-64 on 2018/3/14.
 */

public interface AddressContact {
    interface view extends BaseView {
        /**
         * 设置数据
         *
         * @param dataList
         */
        void setData(AddressALLBean.DataBean data);
        void notifyChange(int pos);

        void setNewAddress();
    }

    interface AddPresent extends BasePresenter {
        void getData(String user_id);
        void delAddress(String del, String user_id, String address_id, int pos);
        void setDefualtAddress(String user_id, String address_id);
    }
}
