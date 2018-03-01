package com.zhss.sjlm.tools;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by win7-64 on 2017/11/16.
 */

public class ViewHolder extends RecyclerView.ViewHolder {
    //用来存放子View 减少find
    private SparseArray views;

    public ViewHolder(View itemView) {
        super(itemView);
        views = new SparseArray<View>();
    }

    //通过id 获取View
    public <T extends View> T getViw(int id) {
        //先从缓存中获取
        View cuView = (View) views.get(id);
        if (cuView == null) {
            cuView = itemView.findViewById(id);
            views.put(id,cuView);
        }
        return (T) cuView;
    }

    //设置textview
    public ViewHolder setText(int id, CharSequence cs) {
        TextView view = getViw(id);
        view.setText(cs);
        return this;
    }
    //设置visible
    public ViewHolder setVisibility(int id,int visible){
       getViw(id).setVisibility(visible);
        return this;
    }
    //设置ImageView
    public  ViewHolder setImageResource(int id,int resource){
        ImageView viw = getViw(id);
        viw.setImageResource(resource);
        return this;
    }
    //设置长按事件
    public void setLongClickListener(View.OnLongClickListener listener){
        itemView.setOnLongClickListener(listener);
    }
    //设置点击事件
    public void setOnclickListner(View.OnClickListener listner){
        itemView.setOnClickListener(listner);
    }
}
