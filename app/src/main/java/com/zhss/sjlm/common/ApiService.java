package com.zhss.sjlm.common;

import com.zhss.sjlm.bean.AddressALLBean;
import com.zhss.sjlm.bean.BaseResult;
import com.zhss.sjlm.bean.CategreyBean;
import com.zhss.sjlm.bean.DiscoverBean;
import com.zhss.sjlm.bean.DiscoverTitleBean;
import com.zhss.sjlm.bean.HomeDataBean;
import com.zhss.sjlm.bean.LoginBean;
import com.zhss.sjlm.bean.MineInfoBean;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
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
    Observable<BaseResult<HomeDataBean.DataBean>> getHomeData();

    //分类
    @GET("classify/classify")
    Observable<BaseResult<List<CategreyBean>>> getCateData();

    //发现栏目
    @GET("Find/findindex")
    Observable<BaseResult<List<DiscoverTitleBean>>> getDiscoverTitle();

    //栏目信息
    @GET("Find/goodsdex")
    Observable<BaseResult<List<DiscoverBean>>> getItemData(@Query("find") int find);

    //个人中心
    @GET("userinfo/index")
    Observable<BaseResult<MineInfoBean.DataBean>> getUserInfo(@Query("uid") String uid);

    //昵称
    @POST("userinfo/update")
    Observable<BaseResult<Void>> upDataNicheng(@Query("uid") String uid, @Query("nickname") String nicheng);

    //真实姓名
    @POST("userinfo/update")
    Observable<BaseResult<Void>> upDataTruename(@Query("uid") String user_id, @Query("truename") String trueName);

    //个人简介
    @POST("userinfo/update")
    Observable<BaseResult<Void>> upDataIntroduction(@Query("uid") String user_id, @Query("introduction") String trueName);

    @POST("Address/add")
    Observable<BaseResult<Void>> upDataAddress(@Query("status") String status, @Query("uid") String uid,
                                               @Query("true_name") String trueName, @Query("tel_phone") String tel_phone,
                                               @Query("area_info") String area_info, @Query("address") String address
    );

    //上传头像
    @Multipart
    @POST("userinfo/upavatar")
    Observable<BaseResult<Void>> upDataPhoto(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> partList);

    //收货地址
    @GET("Address/index")
    Observable<BaseResult<AddressALLBean.DataBean>> getAddress(@Query("uid") String uid);

    //修改收货地址
    @POST("Address/add")
    Observable<BaseResult<Void>> editDataAddress(@Query("status") String status, @Query("address_id") String address_id, @Query("uid") String uid,
                                                 @Query("true_name") String trueName, @Query("tel_phone") String tel_phone,
                                                 @Query("area_info") String area_info, @Query("address") String address);

    //删除 默认地址
    @POST("Address/default")
    Observable<BaseResult<Void>> delAddress(@Query("status") String status, @Query("uid") String user_id, @Query("address_id") String address_id);

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




   */

}
