package com.zhss.sjlm.ui.adapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhss.sjlm.R;
import com.zhss.sjlm.bean.DetailBean;


/**
 * Created by Administrator on 2018/3/20.
 */

public class DetailAdapter extends BaseQuickAdapter<DetailBean, BaseViewHolder> {

    public DetailAdapter() {
        super(R.layout.adapter_detial);
    }

    @Override
    protected void convert(BaseViewHolder helper, DetailBean item) {
        helper.setText(R.id.tv_pay,item.getText1())
                .setText(R.id.tv_yue,item.getText2())
                .setText(R.id.tv_time,item.getText3())
                .setText(R.id.tv_money,item.getText4());
    }
}
