package com.zhss.sjlm.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhss.sjlm.R;
import com.zhss.sjlm.base.BaseActivity;
import com.zhss.sjlm.tools.CircleImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/3/16.
 */
//我的钱包
public class MyWalletActivity extends BaseActivity {

    @BindView(R.id.tv_center)
    TextView tvCenter;
    @BindView(R.id.circle_head)
    CircleImageView circleHead;
    @BindView(R.id.tv_wallet_money)
    TextView tvWalletMoney;
    @BindView(R.id.tv_up)
    TextView tvUp;
    @BindView(R.id.tv_withdraw)
    TextView tvWithdraw;
    @BindView(R.id.ll_comment)
    LinearLayout llComment;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        tvCenter.setText("我的钱包");
    }

    @Override
    protected int getlayoutId() {
        return R.layout.activity_mywallet;
    }

    @OnClick({R.id.circle_head, R.id.tv_wallet_money, R.id.tv_up, R.id.tv_withdraw, R.id.ll_comment})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.circle_head:
                break;
            case R.id.tv_wallet_money:
                break;
            case R.id.tv_up://充值
                startActivity(new Intent(MyWalletActivity.this,UpActivity.class));
                break;
            case R.id.tv_withdraw://提现
                startActivity(new Intent(MyWalletActivity.this, WithDrawAativity.class));
                break;
            case R.id.ll_comment:
                break;
        }
    }
}
