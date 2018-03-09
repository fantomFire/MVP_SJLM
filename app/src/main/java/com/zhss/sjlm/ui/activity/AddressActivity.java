package com.zhss.sjlm.ui.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhss.sjlm.R;
import com.zhss.sjlm.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by win7-64 on 2018/3/9.
 */

public class AddressActivity extends BaseActivity {
    @BindView(R.id.rec_address)
    RecyclerView recAddress;
    @BindView(R.id.tv_up)
    TextView tvUp;
    @BindView(R.id.iv_left)
    LinearLayout ivLeft;
    @BindView(R.id.tv_center)
    TextView tvCenter;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
    tvCenter.setText("收货地址");
    }

    @Override
    protected int getlayoutId() {
        return R.layout.activity_address;
    }




    @OnClick({R.id.iv_left, R.id.tv_up})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_left:
                finish();
                break;
            case R.id.tv_up:
                startActivity(NewAddressActivity.class);
                break;
        }
    }
}
