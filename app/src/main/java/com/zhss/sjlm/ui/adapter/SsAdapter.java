package com.zhss.sjlm.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhss.sjlm.R;
import com.zhss.sjlm.bean.HomeDataBean;
import com.zhss.sjlm.tools.GlideManager;

/**
 * Created by win7-64 on 2018/3/6.
 */

public class SsAdapter  extends BaseQuickAdapter<HomeDataBean.DataBean.Position3Bean.ContentBeanXX ,BaseViewHolder>{
    public SsAdapter() {
        super(R.layout.fooditem);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeDataBean.DataBean.Position3Bean.ContentBeanXX item) {
        helper.setText(R.id.food_name,item.getStore_name())
                .setText(R.id.food_address,item.getLive_store_address());
        GlideManager.loadImage(mContext,item.getStore_image(),helper.getView(R.id.foot_img));
    }
}
