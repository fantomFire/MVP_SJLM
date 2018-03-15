package com.zhss.sjlm.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhss.sjlm.R;
import com.zhss.sjlm.bean.AddressALLBean;

/**
 * Created by win7-64 on 2018/3/14.
 */

public class AddressAdapter extends BaseQuickAdapter<AddressALLBean.DataBean.AddressBean, BaseViewHolder> {
    public AddressAdapter() {
        super(R.layout.adapter_address);
    }

    @Override
    protected void convert(BaseViewHolder helper, AddressALLBean.DataBean.AddressBean item) {
        helper.setText(R.id.txt_name, item.getTrue_name())
                .setText(R.id.txt_mobile, item.getTel_phone())
                .setText(R.id.txt_address, item.getArea_info() + item.getAddress())
                .addOnClickListener(R.id.ll_modify_address)
                .addOnClickListener(R.id.ll_dele)
                .addOnClickListener(R.id.ll_defualt);
        String is_default = item.getIs_default();
        if (is_default.equals("0")) {
            helper.getView(R.id.iv_address).setBackgroundResource(R.mipmap.szl);
        } else {
            helper.getView(R.id.iv_address).setBackgroundResource(R.mipmap.sz1);

        }
    }
}
