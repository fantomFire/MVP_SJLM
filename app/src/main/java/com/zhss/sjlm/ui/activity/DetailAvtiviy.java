package com.zhss.sjlm.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.zhss.sjlm.R;
import com.zhss.sjlm.base.BaseActivity;
import com.zhss.sjlm.bean.DetailBean;
import com.zhss.sjlm.ui.adapter.DetailAdapter;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/3/20.
 */

public class DetailAvtiviy extends BaseActivity {
    @BindView(R.id.rec_detail)
    RecyclerView recDetail;
    @BindView(R.id.tv_center)
    TextView tvCenter;
    private DetailAdapter detailAdapter;
    private DetailBean detailBean;
    private ArrayList<DetailBean> list;

    @Override
    protected void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            detailBean = new DetailBean();
            detailBean.setText1("支付"+i);
            detailBean.setText2("余额："+i);
            detailBean.setText3("时间"+i);
            detailBean.setText4("金额"+i);
            list.add(detailBean);
            System.out.println("i = " + detailBean.getText1());
        }
        detailAdapter.addData(list);
    }

    @Override
    protected void initView() {
        tvCenter.setText("全部");

        recDetail.setLayoutManager(new LinearLayoutManager(this));
        detailAdapter = new DetailAdapter();
        recDetail.setAdapter(detailAdapter);
    }

    @Override
    protected int getlayoutId() {
        return R.layout.activity_detail;
    }

}
