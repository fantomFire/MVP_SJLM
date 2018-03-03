package com.zhss.sjlm.ui.adapter;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by win7-64 on 2018/1/29.
 */

public class FrageVpAdapter extends FragmentStatePagerAdapter {
    FragmentManager fragmentManager;
    List<Fragment> fragments;
    public FrageVpAdapter(FragmentManager fragmentManager, List<Fragment> fragments) {
        super(fragmentManager);
        this.fragmentManager = fragmentManager;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments==null?0:fragments.size();
    }

    @Override
    public Parcelable saveState() {
        return null;
    }
}
