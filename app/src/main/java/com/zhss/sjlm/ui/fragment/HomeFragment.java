package com.zhss.sjlm.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
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
import com.zhss.sjlm.bean.HomeDataBean;
import com.zhss.sjlm.present.HomePresentImpl;
import com.zhss.sjlm.tools.GlideImageLoader;
import com.zhss.sjlm.ui.adapter.FoodAdapter;
import com.zhss.sjlm.ui.adapter.SsAdapter;
import com.zhss.sjlm.ui.adapter.YijuFoodAdapter;
import com.zhss.sjlm.ui.contact.HomeContact;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by win7-64 on 2018/1/23.
 */

public class HomeFragment extends BaseMvpFragment<HomePresentImpl> implements HomeContact.view {
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
    private FoodAdapter foodAdapter;
    private YijuFoodAdapter yijuFoodAdapter;
    private SsAdapter ssAdapter;

    @Override
    protected void initView() {
        //美食
        recMeishi.setLayoutManager(new LinearLayoutManager(mActivity));
        foodAdapter = new FoodAdapter();
        recMeishi.setAdapter(foodAdapter);
        //宜居
        yijuFoodAdapter = new YijuFoodAdapter();
        recYiju.setLayoutManager(new LinearLayoutManager(mActivity));
        recYiju.setAdapter(yijuFoodAdapter);
        //盛世之美
        recSszm.setLayoutManager(new LinearLayoutManager(mActivity));
        ssAdapter = new SsAdapter();
        recSszm.setAdapter(ssAdapter);
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
        mPresenter.getData();
    }

    //设置banner
    @Override
    public void setBanner(List<HomeDataBean.DataBean.BannerBean> bannerData) {
        imgs.clear();
        for (int i = 0; i < bannerData.size(); i++) {
            imgs.add(bannerData.get(i).getBa_url());
        }
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(imgs);
        banner.isAutoPlay(true);
        banner.setDelayTime(2000);
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.start();
    }

    @Override
    public void setFood(HomeDataBean.DataBean.Position1Bean foodData) {
        List<HomeDataBean.DataBean.Position1Bean.ContentBean> content = foodData.getContent();
        tvMeishi.setText(foodData.getTitle());
        foodAdapter.addData(content);
        foodAdapter.notifyDataSetChanged();
    }

    @Override
    public void setYiju(HomeDataBean.DataBean.Position2Bean yijuData) {
        tvJiaju.setText(yijuData.getTitle());
        yijuFoodAdapter.addData(yijuData.getContentX());

    }

    @Override
    public void setSS(HomeDataBean.DataBean.Position3Bean ssData) {
        tvSs.setText(ssData.getTitle());
        ssAdapter.addData(ssData.getContentXX());
    }
}
