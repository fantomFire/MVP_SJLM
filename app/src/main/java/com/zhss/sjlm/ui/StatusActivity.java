package com.zhss.sjlm.ui;

import android.widget.LinearLayout;

import com.zhss.sjlm.R;
import com.zhss.sjlm.base.BaseActivity;
import com.zhss.sjlm.weight.statuslayout.OnRetryListener;
import com.zhss.sjlm.weight.statuslayout.StatusLayoutManager;

/**
 * Created by win7-64 on 2018/2/27.
 */

public class StatusActivity  extends BaseActivity {

    private StatusLayoutManager mStatusLayoutManager;



    public void initStatusLayout() {

        mStatusLayoutManager = StatusLayoutManager.newBuilder(this)
                .contentView(R.layout.activity_content)
                .emptyDataView(R.layout.activity_emptydata)
                .errorView(R.layout.activity_error)
                .loadingView(R.layout.activity_loading)
                .netWorkErrorView(R.layout.activity_networkerror)
                .errorRetryViewId(R.id.button_retry)
                .netWorkErrorRetryViewId(R.id.button_try)
                .emptyDataRetryViewId(R.id.button_retry)
                .onRetryListener(new OnRetryListener() {
                    @Override
                    public void onRetry() {
                        mStatusLayoutManager.showLoading();

                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        mStatusLayoutManager.showContent();
                                    }
                                });
                            }
                        }).start();
                    }
                }).build();


        LinearLayout activity_test_status = (LinearLayout) findViewById(R.id.activity_test_status);

        activity_test_status.addView(mStatusLayoutManager.getRootLayout());

    }

    @Override
    protected void initData() {

    }

    protected void initView() {

        mStatusLayoutManager.showLoading();
   /*     mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mToolbar.inflateMenu(R.menu.menu_main);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId() == R.id.action_content) {
                    mStatusLayoutManager.showContent();
                }
                if(item.getItemId() == R.id.action_emptyData) {
                    mStatusLayoutManager.showEmptyData();
                }
                if(item.getItemId() == R.id.action_error) {
                    mStatusLayoutManager.showError();
                }
                if(item.getItemId() == R.id.action_networkError) {
                    mStatusLayoutManager.showNetWorkError();
                }
                if(item.getItemId() == R.id.action_loading) {
                    mStatusLayoutManager.showLoading();
                }
                return true;
            }
        });*/

    }

    @Override
    protected int getlayoutId() {
        return R.layout.activity_test_status;

    }
}
