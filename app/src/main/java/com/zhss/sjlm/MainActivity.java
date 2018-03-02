package com.zhss.sjlm;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhss.sjlm.tools.PrefUtils;
import com.zhss.sjlm.tools.StatusBarUtils;
import com.zhss.sjlm.ui.adapter.MyPagerAdapter;
import com.zhss.sjlm.ui.fragment.ClassifyFragment;
import com.zhss.sjlm.ui.fragment.DiscoverFragment;
import com.zhss.sjlm.ui.fragment.HomeFragment;
import com.zhss.sjlm.ui.fragment.MerchantFragment;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends FragmentActivity {
    private static final String[] FIVE = new String[]{"首页", "分类", "商家中心", "发现", "我的"};
    private static final String[] FOUR = new String[]{"首页", "分类", "发现", "我的"};
    private static final Integer[] IMAGES1_FIVE = new Integer[]{R.mipmap.f1a, R.mipmap.f2a, R.mipmap.f3a, R.mipmap.f4a, R.mipmap.f5a};
    private static final Integer[] IMAGES2_FIVE = new Integer[]{R.mipmap.f1h, R.mipmap.f2h, R.mipmap.f3h, R.mipmap.f4h, R.mipmap.f5h};
    private static final Integer[] IMAGES1_FOUR = new Integer[]{R.mipmap.f1a, R.mipmap.f2a, R.mipmap.f4a, R.mipmap.f5a};
    private static final Integer[] IMAGES2_FOUR = new Integer[]{R.mipmap.f1h, R.mipmap.f2h, R.mipmap.f4h, R.mipmap.f5h};
    private List<String> mDataList;
    private List<Integer> mImg1;
    private List<Integer> mImg2;
    private ArrayList<Fragment> mPagers = new ArrayList<Fragment>();
    private ViewPager mViewPager;
    public static MainActivity MAIN;


    private String userid;

    private String member_type;
    private boolean isExit = false;
    private Unbinder bind;
    private HomeFragment homeFragment;
    private MyPagerAdapter myPagerAdapter;
    private ClassifyFragment classifyFragment;
     private MerchantFragment merchantFragment;
    private DiscoverFragment discoverFragment;
      /*
       private MineFragment mineFragment;
       private MyPagerAdapter myPagerAdapter;
       private ClassifyFragment classifyFragment;
   */

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutId());
        StatusBarUtils.setColor(this, getResources().getColor(R.color.statusBarColor));
        bind = ButterKnife.bind(this);
        initView();
        initData();
    }


    protected void initView() {
        member_type = PrefUtils.getString(this, "member_type", "1");

        mViewPager = findViewById(R.id.view_pager);
        if (homeFragment == null) {
            homeFragment = new HomeFragment();
            mPagers.add(homeFragment);
        }

        if (classifyFragment == null) {
            classifyFragment = new ClassifyFragment();
            mPagers.add(classifyFragment);
        }

//        if (!member_type.equals("1")) {
        if (merchantFragment == null) {
            merchantFragment = new MerchantFragment();
            mPagers.add(merchantFragment);
//            }
        }

        if (discoverFragment == null) {
            discoverFragment = new DiscoverFragment();
            mPagers.add(discoverFragment);
        }
          /*
        if (mineFragment == null) {
            mineFragment = new MineFragment();
            mPagers.add(mineFragment);
        }*/
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), mPagers);
        mViewPager.setAdapter(myPagerAdapter);
        mViewPager.requestDisallowInterceptTouchEvent(true);
        mViewPager.setCurrentItem(0,false);
        mViewPager.setOffscreenPageLimit(mPagers.size());

    }


    protected void initData() {
        initMagicIndicator();
    }
    private void initMagicIndicator() {
        //在此处判断是用户登录还是商家登录，以显示不同的底部导航
        mDataList = Arrays.asList(FIVE);
//        if (!member_type.equals("1") && !member_type.equals("")) {equals
        mDataList = Arrays.asList(FIVE);
        mImg1 = Arrays.asList(IMAGES1_FIVE);
        mImg2 = Arrays.asList(IMAGES2_FIVE);
//        } else {
//            mDataList = Arrays.asList(FOUR);
//            mImg1 = Arrays.asList(IMAGES1_FOUR);
//            mImg2 = Arrays.asList(IMAGES2_FOUR);
//        }

        MagicIndicator magicIndicator = findViewById(R.id.magic_indicator1);
        magicIndicator.setBackgroundColor(Color.WHITE);
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {


            @Override
            public int getCount() {
                return mDataList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                final int pos = index;
                CommonPagerTitleView commonPagerTitleView = new CommonPagerTitleView(context);

                // load custom layout
                View customLayout = LayoutInflater.from(context).inflate(R.layout.simple_pager_title_layout, null);
                final ImageView titleImg = (ImageView) customLayout.findViewById(R.id.title_img);
                final TextView titleText = (TextView) customLayout.findViewById(R.id.title_text);
                titleImg.setImageResource(mImg1.get(index));
                titleText.setText(mDataList.get(index));


                commonPagerTitleView.setContentView(customLayout);
                commonPagerTitleView.setOnPagerTitleChangeListener(new CommonPagerTitleView.
                        OnPagerTitleChangeListener() {

                    @Override
                    public void onSelected(int index, int totalCount) {
                        System.out.println("currentindex" + index);
                        titleText.setTextColor(Color.parseColor("#f5a11e"));
                        titleImg.setImageResource(mImg2.get(index));
                    }

                    @Override
                    public void onDeselected(int index, int totalCount) {
                        titleText.setTextColor(Color.parseColor("#000000"));
                        titleImg.setImageResource(mImg1.get(index));
                    }

                    @Override
                    public void onLeave(int index, int totalCount, float leavePercent, boolean leftToRight) {
//                        titleImg.setScaleX(1.3f + (0.8f - 1.3f) * leavePercent);
//                        titleImg.setScaleY(1.3f + (0.8f - 1.3f) * leavePercent);
                    }

                    @Override
                    public void onEnter(int index, int totalCount, float enterPercent, boolean leftToRight) {
//                        titleImg.setScaleX(0.8f + (1.3f - 0.8f) * enterPercent);
//                        titleImg.setScaleY(0.8f + (1.3f - 0.8f) * enterPercent);

                    }
                });

                commonPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       /* if (index == mDataList.size() - 1) {
                            //如果为登录，直接跳转到登录界面；否则调到个人中心页面
                            userid = PrefUtils.getString(MainActivity.this, Constants.USER_ID, null);
                            if (null == userid || userid.equals("")) {
                                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                            } else {
                                mViewPager.setCurrentItem(index);
                            }
                        } else {
                            mViewPager.setCurrentItem(index);
                        }*/

                        mViewPager.setCurrentItem(index);
                    }
                });
                return commonPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                return null;
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, mViewPager);
    }
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
