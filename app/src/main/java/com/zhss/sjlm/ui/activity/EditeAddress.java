package com.zhss.sjlm.ui.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zhss.sjlm.R;
import com.zhss.sjlm.base.BaseActivity;
import com.zhss.sjlm.common.RxSchedulerHepler;
import com.zhss.sjlm.common.call.BaseObserver;
import com.zhss.sjlm.tools.Cityselect;
import com.zhss.sjlm.tools.PrefUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by win7-64 on 2018/3/15.
 */

public class EditeAddress extends BaseActivity {
    @BindView(R.id.iv_left)
    LinearLayout ivLeft;
    @BindView(R.id.tv_center)
    TextView tvCenter;
    @BindView(R.id.tv_right)
    TextView tvRight;
    @BindView(R.id.l_share)
    LinearLayout lShare;
    @BindView(R.id.rl_base_title)
    RelativeLayout rlBaseTitle;
    @BindView(R.id.edt_name)
    EditText edtName;
    @BindView(R.id.edt_mobile)
    EditText edtMobile;
    @BindView(R.id.txt_address)
    TextView txtAddress;
    @BindView(R.id.ll_address)
    LinearLayout llAddress;
    @BindView(R.id.edt_address_info)
    EditText edtAddressInfo;
    @BindView(R.id.tv_up)
    TextView tvUp;
    private String user_id;
    private String newAddress;
    private String trueName;
    private String tel;
    private String detailAddress;
    private String userAddressId;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        tvCenter.setText("修改收货地址");
        user_id = PrefUtils.getString(mActivity, "user_id", "");
        Intent intent = getIntent();
        edtName.setText(intent.getStringExtra("userName"));
        txtAddress.setText(intent.getStringExtra("userAddress"));
        edtMobile.setText(intent.getStringExtra("userTel"));
        edtAddressInfo.setText(intent.getStringExtra("userAddressDe"));
        userAddressId = intent.getStringExtra("userAddressId");
    }

    @Override
    protected int getlayoutId() {
        return R.layout.new_address;
    }



    @OnClick({R.id.iv_left, R.id.ll_address, R.id.tv_up})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_left:
                finish();
                break;
            case R.id.ll_address:
                new Cityselect().getCity(txtAddress,mActivity);
                break;
            case R.id.tv_up:
                toUpdata();
                break;
        }
    }
    private void toUpdata() {
        newAddress = txtAddress.getText().toString();
        if(newAddress ==null){
            Toast.makeText(mActivity, "请选择地址", Toast.LENGTH_SHORT).show();
            return;
        }
        trueName = edtName.getText().toString().trim();
        if(trueName ==null){
            Toast.makeText(mActivity, "请输入收货人", Toast.LENGTH_SHORT).show();
            return;
        }
        tel = edtMobile.getText().toString().trim();
        if(tel ==null|| tel.length()!=11){
            Toast.makeText(mActivity, "请核对收货人电话", Toast.LENGTH_SHORT).show();
            return;
        }
        detailAddress = edtAddressInfo.getText().toString().trim();
        if(TextUtils.isEmpty(detailAddress)){
            Toast.makeText(mActivity, "请输入详细地址", Toast.LENGTH_SHORT).show();
            return;
        }
        apiService.editDataAddress("edit",userAddressId,user_id, trueName, tel, newAddress, detailAddress)
                .compose(RxSchedulerHepler.io_main())
                .subscribe(new BaseObserver<Void>(mActivity) {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(mActivity, "修改地址成功", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });

    }
}
