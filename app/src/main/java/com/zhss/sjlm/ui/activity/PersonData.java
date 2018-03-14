package com.zhss.sjlm.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhss.sjlm.R;
import com.zhss.sjlm.base.BaseMvpActivity;
import com.zhss.sjlm.bean.MineInfoBean;
import com.zhss.sjlm.present.PersonPresentImpl;
import com.zhss.sjlm.tools.GlideManager;
import com.zhss.sjlm.tools.PrefUtils;
import com.zhss.sjlm.ui.contact.PersonContact;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;
import me.iwf.photopicker.PhotoPicker;

/**
 * Created by win7-64 on 2018/3/7.
 */

public class PersonData extends BaseMvpActivity<PersonPresentImpl> implements PersonContact.View {

    @BindView(R.id.ll_back)
    LinearLayout llBack;
    @BindView(R.id.civ_avatar)
    CircleImageView civAvatar;
    @BindView(R.id.ll_avatar)
    LinearLayout llAvatar;
    @BindView(R.id.tv_nickname)
    TextView tvNickname;
    @BindView(R.id.ll_nickname)
    LinearLayout llNickname;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.ll_name)
    LinearLayout llName;
    @BindView(R.id.tv_introduce)
    TextView tvIntroduce;
    @BindView(R.id.ll_introduce)
    LinearLayout llIntroduce;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.ll_sex)
    LinearLayout llSex;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.ll_num)
    LinearLayout llNum;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.ll_date)
    LinearLayout llDate;
    @BindView(R.id.tv_area)
    TextView tvArea;
    @BindView(R.id.ll_area)
    LinearLayout llArea;
    @BindView(R.id.tv_autonym)
    TextView tvAutonym;
    @BindView(R.id.ll_autonym)
    LinearLayout llAutonym;
    private String user_id;
    private ArrayList<String> imagePath = new ArrayList<>();

    @Override
    public void setData(MineInfoBean.DataBean dataList) {
        GlideManager.loadImage(this, dataList.getAvatar(), R.mipmap.moren, civAvatar);
        tvNickname.setText(dataList.getNickname());
        tvName.setText(dataList.getTruename());
        tvArea.setText(dataList.getAddr());
        tvIntroduce.setText(dataList.getIntroduction());
        tvSex.setText(dataList.getSex());
        tvDate.setText(dataList.getBirthday());
        String phone = dataList.getPhone();
        if (phone != null && phone.length() == 11) {
            String mStr = phone.substring(3, 7);
            phone.replace(mStr, "****");

        }
        tvNum.setText(phone);
    }

    @Override
    protected void initView() {
        user_id = PrefUtils.getString(this, "user_id", "");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal_details;
    }

    @Override
    protected void initData() {
        mPresenter.getData(user_id);

    }

    @Override
    public PersonPresentImpl createPresenter() {
        return new PersonPresentImpl(this);
    }

    @OnClick({R.id.ll_back, R.id.ll_avatar, R.id.ll_nickname, R.id.ll_name, R.id.ll_introduce,
            R.id.ll_sex, R.id.ll_num, R.id.ll_date, R.id.ll_area, R.id.ll_autonym})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.ll_avatar:
                PermissionGen.with(this)
                        .addRequestCode(200)
                        .permissions(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
                        .request();
                break;
            case R.id.ll_nickname:
                startActivity(NickActivity.class);
                break;
            case R.id.ll_name:
                startActivity(TruenameActivity.class);
                break;
            case R.id.ll_introduce:
                startActivity(PersonDesActivity.class);
                break;
            case R.id.ll_sex:
                break;
            case R.id.ll_num:
                break;
            case R.id.ll_date:
                break;
            case R.id.ll_area:
                startActivity(AddressActivity.class);
                break;
            case R.id.ll_autonym:
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getData(user_id);
    }

    @PermissionSuccess(requestCode = 200)
    public void addImg() {
        ChoosePhotoType();
    }

    @PermissionFail(requestCode = 200)
    public void fail() {
    }

    private void ChoosePhotoType() {
        PhotoPicker.builder()
                .setPhotoCount(1)
                .setShowCamera(true)
                .setPreviewEnabled(false)
                .start(this, PhotoPicker.REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PhotoPicker.REQUEST_CODE) {
            if (data != null) {
                ArrayList<String> photos =
                        data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
                imagePath.clear();
                imagePath.add(photos.get(0));
                if (imagePath != null) {
                    upData(imagePath);
                }
            }

        }
    }
        //上传头像
    private void upData(ArrayList<String> imagePath) {
        //图像转换
    //  String imgStr = ImageCompress.GetImageStr(imagePath);

        mPresenter.upDataPhoto(user_id,imagePath);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        PermissionGen.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }

}
