package com.zhss.sjlm.common.http;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zhss.sjlm.common.ApiService;
import com.zhss.sjlm.common.Contacts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 解晓辉  on 2017/5/24 20:49 *
 * QQ  ：811733738
 * 作用:   提供 Retrofit 网络连接 ApiService
 *
 */

public class RetrofitClient {


    private static RetrofitClient instance;

    private OkHttpClient mOkHttpClient;


    private Context mContext;

    private Retrofit mRetrofit;

    private ApiService mApiService;

    private RetrofitClient(Context context) {
        this.mContext = context;
    }

    public static RetrofitClient getInstance(Context context) {
        if (instance == null) {
            instance = new RetrofitClient(context);
        }
        return instance;
    }


    private OkHttpClient provideOkHttpClient() {
        if (mOkHttpClient == null) {
            mOkHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                   //  .addInterceptor(new ApiHeaders())
                    // .cookieJar(new CookieJarImpl(new PersistentCookieStore(mContext)))*/
                    .build();
        }


        return mOkHttpClient;
    }


    private Retrofit provideRetrofit() {

        if (mRetrofit == null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            mRetrofit = new Retrofit.Builder()
                    .baseUrl(Contacts.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(provideOkHttpClient()).build();
        }

        return mRetrofit;
    }

    public ApiService provideApiService() {
        if (mApiService == null) {

            mApiService = provideRetrofit().create(ApiService.class);
        }
        return mApiService;
    }
    static class ApiHeaders implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Request.Builder builder = request.newBuilder();
            builder.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                    .addHeader("User-Agent", "Mozilla/5.0 (Linux; U; Android 4.1.1; zh-cn; HTC One X - 4.1.1 - API 16 - 720x1280 Build/JRO03S) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30")
                    .addHeader("Accept-Encoding", "gzip")
                    .addHeader("Accept", "*/*")
                    .addHeader("Accept-Language", "zh-cn,zh")
                    .addHeader("Authorization", "");

            Request newRequest = builder.build();

            return chain.proceed(newRequest);
        }
    }

}
