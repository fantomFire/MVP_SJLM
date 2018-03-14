package com.zhss.sjlm.present;

import com.zhss.sjlm.bean.MineInfoBean;
import com.zhss.sjlm.common.RxSchedulerHepler;
import com.zhss.sjlm.common.call.BaseObserver;
import com.zhss.sjlm.ui.contact.PersonContact;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by win7-64 on 2018/3/7.
 */

public class PersonPresentImpl extends BasePresentipl<PersonContact.View> implements PersonContact.PersonPre {
    public PersonPresentImpl(PersonContact.View view) {
        super(view);
    }

    @Override
    public void getData(String user_id) {
        apiService.getUserInfo(user_id)
                .compose(RxSchedulerHepler.io_main())
                .doOnSubscribe(disposable -> addDisposable(disposable))
                .subscribe(new BaseObserver<MineInfoBean.DataBean>(mContext) {
                    @Override
                    public void onSuccess(MineInfoBean.DataBean dataBean) {
                        view.setData(dataBean);
                    }
                });
    }

    @Override
    public void upDataPhoto(String user_id, ArrayList<String> paths) {
        System.out.println("userId"+user_id);
        HashMap<String, RequestBody> params = new HashMap<>();
        params.put("uid",RequestBody.create(MediaType.parse("text/plain"),user_id));
        List<MultipartBody.Part> parts = new ArrayList<>(paths.size());
        for (String imgPath : paths) {
            final File file = new File(imgPath);
            System.out.println("文件路径"+file.getAbsolutePath());
            RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), file);
            RequestBody imageBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            MultipartBody.Part part = MultipartBody.Part.createFormData("uploadfile", file.getName(), requestBody);
            parts.add(part);
        }






/*
        Map<String,RequestBody> photos = new HashMap<>();
        for (String imgPath : paths) {
            final File file = new File(imgPath);
            RequestBody requestBody = RequestBody.create(MediaType.parse("image*//*"), file);
            System.out.println("fuke"  +file.getAbsolutePath());
            photos.put("uploadfile[]\";filename=\""+file.getName(), requestBody);
        }*/



        apiService.upDataPhoto(params,parts)
                .compose(RxSchedulerHepler.io_main())
                .doOnSubscribe(disposable -> addDisposable(disposable))
                .subscribe(new BaseObserver<Void>(mContext) {
                    @Override
                    public void onSuccess(Void aVoid) {
                        System.out.println("上传成功");
                    }
                });
    }


}
