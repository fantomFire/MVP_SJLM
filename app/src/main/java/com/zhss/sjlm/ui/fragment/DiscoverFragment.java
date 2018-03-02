package com.zhss.sjlm.ui.fragment;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.zhss.sjlm.R;
import com.zhss.sjlm.base.BaseMvpFragment;
import com.zhss.sjlm.bean.DiscoverTitleBean;
import com.zhss.sjlm.present.DiscoverPresentImpl;
import com.zhss.sjlm.ui.contact.DiscoverContact;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by win7-64 on 2018/1/23.
 */

public class DiscoverFragment extends BaseMvpFragment<DiscoverPresentImpl> implements DiscoverContact.view {
    @BindView(R.id.discover_migic)
    MagicIndicator discoverMigic;
    @BindView(R.id.discover_vp)
    ViewPager discoverVp;
    private List<DiscoverTitleBean> mtitles;
    private ItemFragment itemFragment;
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void initView() {


    }


   /* protected void initdatas() {
        if (mtitles == null) {
            return;
        }
        //将各个栏目fragment 添加到集合
        for (int i = 0; i < mtitles.size(); i++) {
            itemFragment = new ItemFragment();
            fragments.add(itemFragment);
        }

        //给viewpager 设置adapter
        discoverVp.setAdapter(new FrageVpAdapter(getFragmentManager(), fragments));
        discoverVp.requestDisallowInterceptTouchEvent(true);
        discoverVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                discoverMigic.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                discoverMigic.onPageSelected(position);
                itemFragment.setIndex(mtitles.get(position).getFind_id());

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                discoverMigic.onPageScrollStateChanged(state);
            }
        });
        discoverVp.setOffscreenPageLimit(mtitles.size());
        discoverVp.setCurrentItem(0);
        //栏目数据正确 设置
        initTitle();
    }
*/

    //设置栏目数据
    private void initTitle(List<DiscoverTitleBean> mtitles) {
        CommonNavigator commonNavigator = new CommonNavigator(mActivity);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
              return   mtitles == null ? 0 :mtitles.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int i) {
                ColorTransitionPagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
               simplePagerTitleView.setText(mtitles.get(i).getFind_name());
                simplePagerTitleView.setTextSize(17);
                simplePagerTitleView.setNormalColor(Color.parseColor("#444444"));
                simplePagerTitleView.setSelectedColor(Color.parseColor("#df1839"));

                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        discoverVp.setCurrentItem(i,false);
                       // itemFragment.setIndex(mtitles.get(i).getFind_id());


                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
                linePagerIndicator.setMode(linePagerIndicator.MODE_WRAP_CONTENT);
                linePagerIndicator.setColors(getResources().getColor(R.color.df1839));
                return linePagerIndicator;
            }
        });

        discoverMigic.setNavigator(commonNavigator);
        ViewPagerHelper.bind(discoverMigic, discoverVp);


    }

    @Override
    public int getLayoutId() {
        return R.layout.discover_fragment;
    }

    @Override
    public DiscoverPresentImpl createPresenter() {
        return new DiscoverPresentImpl(this);
    }

    @Override
    protected void initData() {
        mPresenter.getTitle();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void setData(List<DiscoverTitleBean> mtitles) {
        System.out.println("发现"+mtitles.size());

        initTitle(mtitles);
    }
}
