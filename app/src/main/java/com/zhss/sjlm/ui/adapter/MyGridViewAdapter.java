package com.zhss.sjlm.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhss.sjlm.R;
import com.zhss.sjlm.bean.CategreyBean;

import java.util.List;

/**
 * GridView 适配器
 */
public class MyGridViewAdapter extends BaseAdapter {

    private Context mContext;

    /**
     * 每个分组下的每个子项的 GridView 数据集合
     */
    private List<CategreyBean.ContentBean> itemGridList;

    public MyGridViewAdapter(Context mContext, List<CategreyBean.ContentBean> itemGridList) {
        this.mContext = mContext;
        this.itemGridList = itemGridList;
    }

    @Override
    public int getCount() {
        return itemGridList==null?0: itemGridList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemGridList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = View.inflate(mContext, R.layout.gridview_item, null);
        }
        TextView tvGridView = (TextView) convertView.findViewById(R.id.tv_gridview);
        tvGridView.setText(itemGridList.get(position).getClass_name());
        return convertView;
    }
}
