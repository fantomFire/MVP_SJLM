package com.zhss.sjlm.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhss.sjlm.R;
import com.zhss.sjlm.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/3/19.
 */

public class WithDrawInfoAativity extends BaseActivity {
    @BindView(R.id.tv_center)
    TextView tvCenter;
    @BindView(R.id.iv_tip)
    ImageView ivTip;
    @BindView(R.id.tv_bank)
    TextView tvBank;
    @BindView(R.id.tv_bankcard)
    TextView tvBankcard;
    @BindView(R.id.et_money)
    EditText etMoney;
    @BindView(R.id.tv_money_ye)
    TextView tvMoneyYe;
    @BindView(R.id.tv_sure)
    TextView tvSure;
    @BindView(R.id.iv_left)
    LinearLayout ivLeft;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        tvCenter.setText("提现");
    }

    @Override
    protected int getlayoutId() {
        return R.layout.activity_withdrawinfo;
    }


    @OnClick({R.id.iv_left, R.id.tv_sure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_left:
                finish();
                break;
            case R.id.tv_sure:
                break;
        }
    }
}
