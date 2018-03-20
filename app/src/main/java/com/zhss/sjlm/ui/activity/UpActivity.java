package com.zhss.sjlm.ui.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhss.sjlm.R;
import com.zhss.sjlm.base.BaseActivity;
import com.zhss.sjlm.bean.UpBean;
import com.zhss.sjlm.tools.BasePopupWindow;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/3/20.
 */
//充值页面
public class UpActivity extends BaseActivity {
    @BindView(R.id.tv_center)
    TextView tvCenter;
    @BindView(R.id.iv_tip)
    ImageView ivTip;
    @BindView(R.id.tv_bank)
    TextView tvBank;
    @BindView(R.id.tv_bankcard)
    TextView tvBankcard;
    @BindView(R.id.tv_up_money)
    TextView tvUpMoney;
    @BindView(R.id.et_money)
    EditText etMoney;
    @BindView(R.id.tv_sure)
    TextView tvSure;
    @BindView(R.id.ll_up)
    LinearLayout llUp;
    @BindView(R.id.ll_add)
    LinearLayout llAdd;
    @BindView(R.id.iv_right_10)
    ImageView ivRight10;
    @BindView(R.id.ll_parent)
    LinearLayout llParent;
    private ArrayList<UpBean> list;
    private UpAdapter upAdapter;
    private PopupWindow popupWindow;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        tvCenter.setText("充值");
        llAdd.setVisibility(View.VISIBLE);
    }

    @Override
    protected int getlayoutId() {
        return R.layout.activity_up;
    }

    @OnClick({R.id.ll_up, R.id.tv_sure, R.id.ll_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_up:
                break;
            case R.id.tv_sure:
                break;
            case R.id.ll_add:
                dialogPopWindow();
                break;
        }
    }

    private void dialogPopWindow() {
        //设置布局
        View inflate = LayoutInflater.from(UpActivity.this).inflate(R.layout.up_pop_menu, null);
        RecyclerView recUpPop = inflate.findViewById(R.id.rec_up_pop);
        popupWindow = new BasePopupWindow(this);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setContentView(inflate);

        //设置popWindow背景颜色
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        //设置点击popuWindow视图以外的地方消失
        popupWindow.setOutsideTouchable(true);
        //先执行popuWindow相关的焦点
        popupWindow.setFocusable(true);
        //显示popuWindow的具体位置
        popupWindow.showAtLocation(llParent, Gravity.BOTTOM, 0, 0);

        recUpPop.setLayoutManager(new LinearLayoutManager(this));
        upAdapter = new UpAdapter();
        recUpPop.setAdapter(upAdapter);
        getData();
    }

    private void getData() {
        list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            UpBean upBean = new UpBean();
            upBean.setBankName("银行卡" + i);
            upBean.setBankIdcard("尾号" + i + "储蓄卡");
            list.add(upBean);
        }
        upAdapter.addData(list);
        upAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                tvBank.setText(list.get(position).getBankName());
                tvBankcard.setText(list.get(position).getBankIdcard());
                popupWindow.dismiss();
            }
        });
    }

    private class UpAdapter extends BaseQuickAdapter<UpBean, BaseViewHolder> {


        public UpAdapter() {
            super(R.layout.recy_withdraw_adapter);
        }

        @Override
        protected void convert(BaseViewHolder helper, UpBean item) {
            helper.setText(R.id.tv_bank, item.getBankName())
                    .setText(R.id.tv_bankcard, item.getBankIdcard());
        }
    }
}
