package com.zhss.sjlm.ui.fragment;

import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.zhss.sjlm.R;
import com.zhss.sjlm.base.BaseMvpFragment;
import com.zhss.sjlm.bean.FoodBean;
import com.zhss.sjlm.bean.LoginBean;
import com.zhss.sjlm.present.HomePresentImpl;
import com.zhss.sjlm.tools.CommonLinearLayoutManager;
import com.zhss.sjlm.tools.GlideImageLoader;
import com.zhss.sjlm.ui.contact.HomeContact;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by win7-64 on 2018/1/23.
 */

public class HomeFragment extends BaseMvpFragment<HomePresentImpl>implements HomeContact.view {
    @BindView(R.id.iv_dingwei)
    ImageView ivDingwei;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.iv_xiaoxi)
    ImageView ivXiaoxi;
    @BindView(R.id.rl_headtitle)
    RelativeLayout rlHeadtitle;
    @BindView(R.id.ll_search)
    LinearLayout llSearch;
    @BindView(R.id.title_01)
    TextView title01;
    @BindView(R.id.iv_01)
    LinearLayout iv01;
    @BindView(R.id.title_02)
    TextView title02;
    @BindView(R.id.iv_02)
    LinearLayout iv02;
    @BindView(R.id.imageView4)
    ImageView imageView4;
    @BindView(R.id.title_03)
    TextView title03;
    @BindView(R.id.iv_03)
    LinearLayout iv03;
    @BindView(R.id.title_04)
    TextView title04;
    @BindView(R.id.iv_04)
    LinearLayout iv04;
    @BindView(R.id.title_05)
    TextView title05;
    @BindView(R.id.iv_05)
    LinearLayout iv05;
    @BindView(R.id.title_06)
    TextView title06;
    @BindView(R.id.iv_06)
    LinearLayout iv06;
    @BindView(R.id.title_07)
    TextView title07;
    @BindView(R.id.iv_cos)
    LinearLayout ivCos;
    @BindView(R.id.iv_vr3d)
    LinearLayout ivVr3d;
    @BindView(R.id.rec_meishi)
    RecyclerView recMeishi;
    @BindView(R.id.rec_yiju)
    RecyclerView recYiju;
    @BindView(R.id.rec_sszm)
    RecyclerView recSszm;
    Unbinder unbinder;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.tv_meishi)
    TextView tvMeishi;
    @BindView(R.id.tv_jiaju)
    TextView tvJiaju;
    @BindView(R.id.tv_ss)
    TextView tvSs;
    Unbinder unbinder1;
    @BindView(R.id.fl_content)
    FrameLayout flContent;
    private ArrayList<String> imgs = new ArrayList<>();

    private ArrayList<FoodBean> foodBeans;
    @Override
    protected void initView() {
  /*      *//* getStateView().setRootView(flContent);
         getStateView().showLoading();*//*
        mStateView = StateView.inject(flContent);
        mStateView.showLoading();*/

        CommonLinearLayoutManager linearLayoutManager = new CommonLinearLayoutManager(getActivity());
        linearLayoutManager.setScrollEnable(false);
        recMeishi.setLayoutManager(linearLayoutManager);
      /*  foodAdapter = new FoodAdapter(getActivity(), foodBeans);
        recMeishi.setAdapter(foodAdapter);
*/

        addData();
        //设置banner
        setBanner();
        //设置美食

        //设置宜居
        setYiju();
    }

    private void setBanner() {
        imgs.clear();
        imgs.add("http://sssm.test.zhonghuass.cn/public/image/home/4.jpg");
        imgs.add("http://sssm.test.zhonghuass.cn/public/image/home/1.jpg");
        imgs.add("http://sssm.test.zhonghuass.cn/public/image/home/4.jpg");
        imgs.add("http://sssm.test.zhonghuass.cn/public/image/home/1.jpg");

        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(imgs);
        banner.isAutoPlay(true);
        banner.setDelayTime(2000);
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.start();

    }

    private void setYiju() {
     /*   CommonLinearLayoutManager linearLayoutManager = new CommonLinearLayoutManager(getActivity());
        linearLayoutManager.setScrollEnable(false);
        recYiju.setLayoutManager(linearLayoutManager);

        recYiju.setAdapter(new YijuFoodAdapter(getActivity(), foodBeans));*/
    }
    private void addData() {
        foodBeans = new ArrayList<>();
        FoodBean foodBean;
        for (int i = 0; i < 5; i++) {
            foodBean = new FoodBean();

            foodBean.address = "大雁塔";
            foodBean.name = "天上人间" + i;

            foodBean.img = R.mipmap.meizi1;
            foodBeans.add(foodBean);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.home_fragment;
    }

    @Override
    public HomePresentImpl createPresenter() {
        return new HomePresentImpl(this);
    }
    @Override
    protected void initData() {
       // mPresenter.getData();
    }


    @Override
    public void setData(LoginBean dataList) {

    }
}
