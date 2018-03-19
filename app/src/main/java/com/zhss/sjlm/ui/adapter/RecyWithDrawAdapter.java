package com.zhss.sjlm.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhss.sjlm.R;
import com.zhss.sjlm.bean.User;


/**
 * Created by Administrator on 2018/3/19.
 */

public class RecyWithDrawAdapter extends BaseQuickAdapter<User, BaseViewHolder> {

    public RecyWithDrawAdapter() {
        super(R.layout.recy_withdraw_adapter);
    }

    @Override
    protected void convert(BaseViewHolder helper, User item) {
        helper.setText(R.id.tv_bank, item.getBankName())
                .setText(R.id.tv_bankcard, item.getBankCard());

    }


}
