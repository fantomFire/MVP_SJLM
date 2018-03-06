package com.zhss.sjlm.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhss.sjlm.R;
import com.zhss.sjlm.bean.HomeDataBean;
import com.zhss.sjlm.tools.GlideManager;

/**
 * Created by win7-64 on 2018/3/6.
 */

public class YijuFoodAdapter  extends BaseQuickAdapter<HomeDataBean.DataBean.Position2Bean.ContentBeanX,BaseViewHolder>{
    public YijuFoodAdapter() {
        super(R.layout.yiju_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeDataBean.DataBean.Position2Bean.ContentBeanX item) {
        helper.setText(R.id.yiju_name,item.getStore_name())
                .setText(R.id.yiju_address,item.getLive_store_address());
        GlideManager.loadImage(mContext,item.getStore_image(),helper.getView(R.id.image));
    }
}
