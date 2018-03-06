package com.zhss.sjlm.ui.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhss.sjlm.R;
import com.zhss.sjlm.bean.DiscoverBean;
import com.zhss.sjlm.common.Contacts;
import com.zhss.sjlm.tools.GlideManager;

/**
 * Created by win7-64 on 2018/1/29.
 */

public class DiscoverAdapter extends BaseMultiItemQuickAdapter<DiscoverBean, BaseViewHolder> {


    public DiscoverAdapter() {
        super(null);
        addItemType(Contacts.TYPE_DISCOVER_ONE_IMG, R.layout.hor_item);
        addItemType(Contacts.TYPE_DISCOVER_MULTI_IMG, R.layout.ver_item);
    }


    @Override
    protected void convert(BaseViewHolder helper, DiscoverBean item) {
        switch (helper.getItemViewType()) {
            case Contacts.TYPE_DISCOVER_ONE_IMG:

                helper.setText(R.id.food_address, item.getLive_store_address())
                        .setText(R.id.food_name, item.getStore_name());
                GlideManager.loadImage(mContext, item.getStore_image(), (ImageView) helper.getView(R.id.foot_img));
                break;
            case Contacts.TYPE_DISCOVER_MULTI_IMG:
                helper.setText(R.id.ver_address, String.format("%s", item.getLive_store_address()))
                        .setText(R.id.ver_name, String.format("%s", item.getStore_name()));
                GlideManager.loadImage(mContext, item.getStore_image(), (ImageView) helper.getView(R.id.ver_img));

                break;
        }
    }

}
