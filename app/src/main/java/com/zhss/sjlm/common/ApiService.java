package com.zhss.sjlm.common;

import com.zhss.sjlm.bean.BaseResult;
import com.zhss.sjlm.bean.LoginBean;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by win7-64 on 2018/2/27.
 */

public interface ApiService {

    //登录
    @POST("Login/sign")
    Observable<BaseResult<LoginBean>> loading(@Query("mobile") String username, @Query("password") String password);


    @POST("getMemberInfo")
    Observable<BaseResult<String>> getMemberInfo();

    @POST("getCateProduct")
    Observable<BaseResult<String>> getCateProduct();


    @POST("memberLogout")
    Observable<BaseResult<String>> logout();

    @Streaming
    @GET
    Call<ResponseBody> downloadFile(@Url String fileUrl);



    @GET
    @Streaming
    Flowable<Response<ResponseBody>> download(@Url String url);

    @GET
    @Streaming
    Flowable<ResponseBody> download2(@Url String url);

}
