package com.zhss.sjlm.ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhss.sjlm.MainActivity;
import com.zhss.sjlm.R;
import com.zhss.sjlm.base.BaseMvpActivity;
import com.zhss.sjlm.bean.LoginBean;
import com.zhss.sjlm.present.LongPresent;
import com.zhss.sjlm.ui.contact.LoginContact;
import com.zhss.sjlm.ui.contact.LoginContact.LoginPren;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by win7-64 on 2018/2/27.
 */

public class LoginActivity extends BaseMvpActivity<LoginPren> implements LoginContact.view {


    @BindView(R.id.edt_phone)
    EditText edtPhone;
    @BindView(R.id.edt_pass)
    EditText edtPass;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.tv_forget)
    TextView tvForget;
    @BindView(R.id.ll_content)
    LinearLayout llContent;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {

    }

    @Override
    public LoginPren createPresenter() {
        return new LongPresent(this);
    }



    @OnClick({R.id.btn_login, R.id.tv_register, R.id.tv_forget})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:

                mPresenter.getData(edtPhone.getText().toString(), edtPass.getText().toString());
               // startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.tv_register:
             //   startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.tv_forget:
              //  startActivity(new Intent(this, ForgetPassActivity.class));
                break;
        }
    }

    @Override
    public void setData(LoginBean dataList) {
        startActivity(MainActivity.class);
    }
}
