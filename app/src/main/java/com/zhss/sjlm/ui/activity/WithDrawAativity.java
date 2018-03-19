package com.zhss.sjlm.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zhss.sjlm.R;
import com.zhss.sjlm.base.BaseActivity;
import com.zhss.sjlm.bean.User;
import com.zhss.sjlm.ui.adapter.RecyWithDrawAdapter;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/3/16.
 */
//提现
public class WithDrawAativity extends BaseActivity {
    @BindView(R.id.recyclear)
    RecyclerView recyclear;
    @BindView(R.id.tv_center)
    TextView tvCenter;
    private ArrayList<User> list = new ArrayList<>();
    private RecyWithDrawAdapter withDrawAdapter;
    private User user;

    @Override
    protected void initData() {
        getData();
    }

    private void getData() {

        for (int i = 0; i < 4; i++) {
            user = new User();
            user.setName("银行卡信息" + i);
            list.add(user);
        }
        withDrawAdapter.addData(list);
        withDrawAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(mActivity, "posiont" + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mActivity, WithDrawInfoAativity.class);
                intent.putExtra("position", list.get(position).getName());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initView() {

        tvCenter.setText("提现");

        recyclear.setLayoutManager(new LinearLayoutManager(this));
        withDrawAdapter = new RecyWithDrawAdapter();
        recyclear.setAdapter(withDrawAdapter);
    }

    @Override
    protected int getlayoutId() {
        return R.layout.activity_withdraw;
    }

}
