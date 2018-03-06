package com.zhss.sjlm.ui.contact;

import com.zhss.sjlm.bean.HomeDataBean;
import com.zhss.sjlm.present.BasePresenter;
import com.zhss.sjlm.ui.BaseView;

import java.util.List;

/**
 * Created by win7-64 on 2018/3/1.
 */

public interface HomeContact {
    interface view extends BaseView {
        /**
         * 设置数据
         *
         * @param
         */
        void setBanner(List<HomeDataBean.DataBean.BannerBean> banner);

        void setFood(HomeDataBean.DataBean.Position1Bean position1);

        void setYiju(HomeDataBean.DataBean.Position2Bean position2);
        void setSS(HomeDataBean.DataBean.Position3Bean position3);
    }

    interface HomePresent extends BasePresenter {

        void getData();
    }
}
