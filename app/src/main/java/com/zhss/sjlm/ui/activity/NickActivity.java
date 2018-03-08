package com.zhss.sjlm.ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zhss.sjlm.R;
import com.zhss.sjlm.base.BaseActivity;
import com.zhss.sjlm.common.RxSchedulerHepler;
import com.zhss.sjlm.common.call.BaseObserver;
import com.zhss.sjlm.tools.PrefUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by win7-64 on 2018/3/7.
 */

public class NickActivity extends BaseActivity {
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.tv_up)
    TextView tvUp;
    @BindView(R.id.iv_left)
    LinearLayout ivLeft;
    @BindView(R.id.tv_center)
    TextView tvCenter;
    @BindView(R.id.tv_right)
    TextView tvRight;
    @BindView(R.id.l_share)
    LinearLayout lShare;
    private String user_id;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        user_id = PrefUtils.getString(mActivity, "user_id", "");
        tvCenter.setText("修改昵称");
    }

    @Override
    protected int getlayoutId() {
        return R.layout.activity_nicheng;
    }

    @OnClick({R.id.iv_left, R.id.tv_up})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_left:
                break;
            case R.id.tv_up:
                String nicheng = etName.getText().toString().trim();
                if (nicheng == null || nicheng.equals("")) {
                    Toast.makeText(mApplication, "昵称不能为空", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    toUpload(nicheng);
                }
                break;
        }
    }

    private void toUpload(String nicheng) {
        apiService.upDataNicheng(user_id, nicheng)
                .compose(RxSchedulerHepler.io_main())
                .subscribe(new BaseObserver<Void>(mActivity) {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(mActivity, "修改成功", Toast.LENGTH_SHORT).show();

                    }
                });

    }
}
