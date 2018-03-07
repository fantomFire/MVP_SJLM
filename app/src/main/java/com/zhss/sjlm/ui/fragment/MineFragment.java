package com.zhss.sjlm.ui.fragment;


import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zhss.sjlm.R;
import com.zhss.sjlm.base.BaseMvpFragment;
import com.zhss.sjlm.bean.MineInfoBean;
import com.zhss.sjlm.present.MinePresentImpl;
import com.zhss.sjlm.tools.GlideManager;
import com.zhss.sjlm.tools.PrefUtils;
import com.zhss.sjlm.ui.activity.PersonData;
import com.zhss.sjlm.ui.contact.MainContact;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by win7-64 on 2018/1/23.
 */

public class MineFragment extends BaseMvpFragment<MinePresentImpl> implements MainContact.view {

    @BindView(R.id.iv_shezhi)
    ImageView ivShezhi;
    @BindView(R.id.img_sixin)
    ImageView imgSixin;
    @BindView(R.id.txt_sixin_number)
    TextView txtSixinNumber;
    @BindView(R.id.circle_image)
    CircleImageView circleImage;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_des)
    TextView tvDes;
    @BindView(R.id.my_wallet)
    TextView myWallet;
    @BindView(R.id.my_integral)
    TextView myIntegral;
    @BindView(R.id.my_attention)
    TextView myAttention;
    @BindView(R.id.ll_wddd)
    LinearLayout llWddd;
    @BindView(R.id.ll_agent)
    LinearLayout llAgent;
    @BindView(R.id.ll_comment)
    LinearLayout llComment;
    @BindView(R.id.ll_relation)
    LinearLayout llRelation;
    @BindView(R.id.cur_version)
    TextView curVersion;
    @BindView(R.id.ll_version)
    LinearLayout llVersion;
    Unbinder unbinder;
    @BindView(R.id.ll_person)
    LinearLayout llPerson;
    Unbinder unbinder1;
    private String user_id;

    @Override
    protected void initView() {
        user_id = PrefUtils.getString(mActivity, "user_id", "");
    }

    @Override
    protected void initData() {
        if (user_id == null || user_id.equals("")) {
            Toast.makeText(mActivity, "用户信息有误!请重新登陆", Toast.LENGTH_SHORT).show();
            return;
        } else {
            mPresenter.getUserInfo(user_id);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.main_fragment;
    }

    @Override
    public MinePresentImpl createPresenter() {
        return new MinePresentImpl(this);
    }


    @Override
    public void setData(MineInfoBean.DataBean dataList) {
        GlideManager.loadImage(mActivity, dataList.getAvatar(), R.mipmap.meizi1, circleImage);
        tvName.setText(dataList.getNickname());
        tvDes.setText(dataList.getIntroduction());
    }

    @OnClick({R.id.iv_shezhi, R.id.img_sixin, R.id.my_wallet, R.id.my_integral, R.id.my_attention,R.id.ll_person,
            R.id.ll_wddd, R.id.ll_agent, R.id.ll_comment, R.id.ll_relation, R.id.ll_version})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_shezhi:
                break;
            case R.id.img_sixin:
                break;
            case R.id.my_wallet:
                break;
            case R.id.my_integral:
                break;
            case R.id.my_attention:
                break;
            case R.id.ll_wddd:
                break;
            case R.id.ll_agent:
                break;
            case R.id.ll_comment:
                break;
            case R.id.ll_relation:
                break;
            case R.id.ll_version:
                break;
            case R.id.ll_person:
                startActivity(PersonData.class);
                break;
        }
    }



    @OnClick()
    public void onViewClicked() {
    }
}
