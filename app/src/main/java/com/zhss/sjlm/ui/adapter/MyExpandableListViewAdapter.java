package com.zhss.sjlm.ui.adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zhss.sjlm.R;
import com.zhss.sjlm.bean.CategreyBean;

import java.util.List;

/**
 * ExpandableListView 适配器
 */
public class MyExpandableListViewAdapter extends BaseExpandableListAdapter {

    private Context mContext;
    private List<CategreyBean> dataList;

    private GridView gridView;

    public MyExpandableListViewAdapter(Context context) {
        mContext = context;

    }

    @Override
    public int getGroupCount() {
        return dataList == null ? 0 : dataList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        // return dataList.get(groupPosition).getContent()==null?0:dataList.get(groupPosition).getContent().size();
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return dataList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return dataList.get(groupPosition).getContent();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup
            parent) {
        if (null == convertView) {
            convertView = View.inflate(mContext, R.layout.expandablelist_group, null);
        }
        ImageView ivGroup = (ImageView) convertView.findViewById(R.id.iv_group);
        Glide.with(mContext)
                .load(dataList.get(groupPosition).getClass_image())
                .into(ivGroup);
        System.out.println("图片地址"+dataList.get(groupPosition).getClass_image());
        TextView tvGroup = (TextView) convertView.findViewById(R.id.tv_group);
        // 如果是展开状态，就显示展开的箭头，否则，显示折叠的箭头
        if (isExpanded) {
            ivGroup.setImageResource(R.mipmap.ico1);
        } else {
            ivGroup.setImageResource(R.mipmap.ico2);
        }
        // 设置分组组名
        tvGroup.setText(dataList.get(groupPosition).getClass_name());
        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View
            convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = View.inflate(mContext, R.layout.expandablelist_item, null);
        }
        // 因为 convertView 的布局就是一个 GridView，
        // 所以可以向下转型为 GridView
        gridView = (GridView) convertView.findViewById(R.id.gridview);
        // 创建 GridView 适配器
        List<CategreyBean.ContentBean> msgBean = dataList.get(groupPosition).getContent();
        if (msgBean != null) {
            MyGridViewAdapter gridViewAdapter = new MyGridViewAdapter(mContext, msgBean);
            gridView.setAdapter(gridViewAdapter);
        }
        //  gridView.setAdapter(gridViewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext, "点击了第" + (groupPosition + 1) + "组，第" +
                        (position + 1) + "项", Toast.LENGTH_SHORT).show();
            }
        });
       /* View mView = new View(mContext);
        RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 6);
        mView.setLayoutParams(params);
        gridView.addView(mView);*/
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    public void setData(List<CategreyBean> dataList) {

        this.dataList = dataList;
        System.out.println(dataList.size()+"=======================");
    }
}
