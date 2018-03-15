package com.zhss.sjlm.ui.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zhss.sjlm.R;
import com.zhss.sjlm.base.BaseMvpActivity;
import com.zhss.sjlm.bean.AddressALLBean;
import com.zhss.sjlm.present.AddressImpl;
import com.zhss.sjlm.tools.CustomDialog;
import com.zhss.sjlm.tools.PrefUtils;
import com.zhss.sjlm.ui.adapter.AddressAdapter;
import com.zhss.sjlm.ui.contact.AddressContact;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by win7-64 on 2018/3/9.
 */

public class AddressActivity extends BaseMvpActivity<AddressImpl> implements AddressContact.view {
    @BindView(R.id.rec_address)
    RecyclerView recAddress;
    @BindView(R.id.tv_up)
    TextView tvUp;
    @BindView(R.id.iv_left)
    LinearLayout ivLeft;
    @BindView(R.id.tv_center)
    TextView tvCenter;
    private AddressAdapter addressAdapter;
    private String user_id;
    private List<AddressALLBean.DataBean.AddressBean> address = new ArrayList<>();

    private View inflate;

    @Override
    protected void initData() {
        mPresenter.getData(user_id);
    }

    @Override
    public AddressImpl createPresenter() {
        return new AddressImpl(this);
    }

    @Override
    protected void initView() {
        tvCenter.setText("收货地址");
        user_id = PrefUtils.getString(this, "user_id", "");
        recAddress.setLayoutManager(new LinearLayoutManager(this));
        addressAdapter = new AddressAdapter();
        recAddress.setAdapter(addressAdapter);

    }

    @Override
    protected int getLayoutId() {
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

    @Override
    public void setData(AddressALLBean.DataBean data) {
        address = data.getAddress();
        if (address != null && address.size() > 0) {
            addressAdapter.replaceData(address);
            addressAdapter.notifyDataSetChanged();
        }


        addressAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {

            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
            final int    pos = position;
                String address_id = address.get(position).getAddress_id();

                switch (view.getId()) {
                    case R.id.ll_modify_address:
                        // startActivity(EditeAddress.class);
                        Intent intent = new Intent(AddressActivity.this, EditeAddress.class);
                        intent.putExtra("userName", address.get(position).getTrue_name());
                        intent.putExtra("userTel", address.get(position).getTel_phone());
                        intent.putExtra("userAddress", address.get(position).getAddress());
                        intent.putExtra("userAddressDe", address.get(position).getArea_info());
                        intent.putExtra("userAddressId", address_id);
                        startActivity(intent);
                        break;
                    case R.id.ll_dele:
                        System.out.println("userid" + user_id + "address" + address_id);
                        deleteData(address_id,pos);

                        break;
                    case R.id.ll_defualt:
                        defualtAddress(address_id);
                        break;
                }
            }
        });
    }
    //设置默认地址
    private void defualtAddress(String address_id) {
        mPresenter.setDefualtAddress(user_id,address_id);
    }

    private void deleteData(String address_id, int pos) {
        inflate = LayoutInflater.from(this).inflate(R.layout.delete_address, null);
        final CustomDialog dialog = new CustomDialog(this, 0, 0, inflate, R.style.MyDialog);
        dialog.show();
        inflate.findViewById(R.id.txt_dialog_no).setOnClickListener(view -> dialog.dismiss()
        );
        inflate.findViewById(R.id.txt_dialog_yes).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        mPresenter.delAddress("del", user_id, address_id,pos);
                        dialog.dismiss();
                    }
                }
        );
        //
    }

    @Override
    public void notifyChange(int pos) {

        Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show();
        address.remove(pos);

        addressAdapter.replaceData(address);
        addressAdapter.notifyDataSetChanged();
    }

    @Override
    public void setNewAddress() {
        Toast.makeText(this, "设置默认地址成功!", Toast.LENGTH_SHORT).show();
            mPresenter.getData(user_id);
    }


    @Override
    protected void onResume() {
        super.onResume();
       mPresenter.getData(user_id);
    }
}
