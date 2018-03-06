package com.zhss.sjlm.ui.fragment;

import android.widget.ExpandableListView;

import com.zhss.sjlm.R;
import com.zhss.sjlm.base.BaseMvpFragment;
import com.zhss.sjlm.bean.CategreyBean;
import com.zhss.sjlm.present.ClassfyPresentImpl;
import com.zhss.sjlm.ui.adapter.MyExpandableListViewAdapter;
import com.zhss.sjlm.ui.contact.ClassfyContact;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by win7-64 on 2018/1/23.
 */

public class ClassifyFragment extends BaseMvpFragment<ClassfyPresentImpl> implements ClassfyContact.view {

    @BindView(R.id.expandableList)
    ExpandableListView expandableList;

    private List<CategreyBean> dataList = new ArrayList<>();
    private MyExpandableListViewAdapter adapter;


    @Override
    protected void initView() {
        adapter = new MyExpandableListViewAdapter(mActivity);
        expandableList.setAdapter(adapter);
        // 隐藏分组指示器
        expandableList.setGroupIndicator(null);
        // 默认展开第一组
//        expandableList.expandGroup(0);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_classify;
    }

    @Override
    protected void initData() {
        mPresenter.getData();
    }

    @Override
    public ClassfyPresentImpl createPresenter() {
        return new ClassfyPresentImpl(this);
    }

    @Override
    public void setData(List<CategreyBean> data) {
        adapter.setData(data);
    }
}

