package com.zhss.sjlm.tools;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by win7-64 on 2017/11/16.
 */

public  abstract class CommonRecyclerAdapter<T> extends RecyclerView.Adapter<ViewHolder> {
    Context context;
    List<T> datas;
    int resId;

    public CommonRecyclerAdapter(Context context, int resId) {
        this.context = context;

        this.resId = resId;

    }
     public void setData(List<T> datas){
         this.datas = datas;
     }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(resId, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        convert(holder,datas.get(position));
    }

    protected abstract void convert(ViewHolder holder, T data);

    @Override
    public int getItemCount() {
        return datas==null?0:datas.size();
    }
}
