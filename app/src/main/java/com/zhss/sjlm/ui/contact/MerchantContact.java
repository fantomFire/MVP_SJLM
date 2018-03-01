package com.zhss.sjlm.ui.contact;

import com.zhss.sjlm.bean.CategreyBean;
import com.zhss.sjlm.present.BasePresenter;
import com.zhss.sjlm.ui.BaseView;

import java.util.List;

/**
 * Created by win7-64 on 2018/3/1.
 */

public interface MerchantContact {
    interface  view extends BaseView{

        void setData(List<CategreyBean> categreyBeans);
    }
    
    interface MerchantPresent extends BasePresenter{


        void getMerchantData();
    }
    
}
