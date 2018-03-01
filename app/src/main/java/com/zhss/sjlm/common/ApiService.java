package com.zhss.sjlm.common;

import com.zhss.sjlm.bean.BaseResult;
import com.zhss.sjlm.bean.CategreyBean;
import com.zhss.sjlm.bean.HomeDataBean;
import com.zhss.sjlm.bean.LoginBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by win7-64 on 2018/2/27.
 */

public interface ApiService {

    //登录
    @POST("Login/sign")
    Observable<BaseResult<LoginBean>> loading(@Query("mobile") String username, @Query("password") String password);

    //首页数据
    @GET("Homepage/home")
    Observable<HomeDataBean> getHomeData();

    //分类
    @GET("classify/classify")
    Observable<BaseResult<List<CategreyBean>>> getCateData();
 /*
    //获取验证码
    @POST("Service/getyzm")
    Observable<Yanzhengma> getYzmCode(@Query("mobile") String mobile);

    //注册接口
    @POST("Login/register")
    Observable<RegistBean> toRegist(@Query("mobile") String mPhone, @Query("code") String code, @Query("password") String mPass);

    //修改密码
    @POST("Login/password")
    Observable<RegistBean> modifyNewpass(@Query("mobile") String mPhone, @Query("code") String mCode,
                                         @Query("password") String mPass, @Query("type") String type);

    //个人中心
    @GET("userinfo/index")
    Observable<MineInfoBean> getUserInfo(@Query("uid")String uid);
    //发现栏目
    @GET("Find/findindex")
    Observable<DiscoverTitleBean> getDiscoverTitle();
    //栏目信息
    @GET("Find/goodsdex")
    Observable<DiscoverBean> getItemData(@Query("find") String find);
   */

}
