package com.zhss.sjlm.tools;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

/**
 * Created by win7-64 on 2017/11/16.
 */

public class CommonLinearLayoutManager extends LinearLayoutManager {
    private boolean flag = true;
    public CommonLinearLayoutManager(Context context) {
        super(context);
    }

    @Override
    public boolean canScrollVertically() {
        return flag&&super.canScrollVertically();
    }
    public void setScrollEnable(boolean flag){
        this.flag = flag;
    }
}
