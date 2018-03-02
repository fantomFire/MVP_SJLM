package com.zhss.sjlm.ui.fragment;

import com.zhss.sjlm.R;
import com.zhss.sjlm.base.BaseMvpFragment;
import com.zhss.sjlm.bean.CategreyBean;
import com.zhss.sjlm.present.MerchantPresentImpl;
import com.zhss.sjlm.ui.contact.MerchantContact;

import java.util.List;

/**
 * Created by win7-64 on 2018/1/23.
 */

public class MerchantFragment extends BaseMvpFragment<MerchantPresentImpl> implements MerchantContact.view{

    @Override
    protected void initData() {

    }

    @Override
    public MerchantPresentImpl createPresenter() {
        return new MerchantPresentImpl(this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_merchant;
    }

    @Override
    public void setData(List<CategreyBean> categreyBeans) {

    }
}
