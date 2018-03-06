package com.zhss.sjlm.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import com.zhss.sjlm.R;
import com.zhss.sjlm.base.BaseMvpFragment;
import com.zhss.sjlm.bean.DiscoverBean;
import com.zhss.sjlm.present.ItemFragmentPrenImpl;
import com.zhss.sjlm.ui.adapter.DiscoverAdapter;
import com.zhss.sjlm.ui.contact.DiscoverItemContact;

import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by win7-64 on 2018/1/29.
 */

public class ItemFragment extends BaseMvpFragment<ItemFragmentPrenImpl> implements DiscoverItemContact.view {
    @BindView(R.id.rec_discover)
    RecyclerView recDiscover;
    Unbinder unbinder;
    @BindView(R.id.fl_content)
    FrameLayout flContent;
    private int currentId=1;
    private DiscoverAdapter discoverAdapter;


    @Override
    protected void initView() {
        recDiscover.setLayoutManager(new LinearLayoutManager(mActivity));
        discoverAdapter = new DiscoverAdapter();
        recDiscover.setAdapter(discoverAdapter);

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_item;
    }


    @Override
    protected void initData() {
        mPresenter.getData(currentId);

    }

    @Override
    public ItemFragmentPrenImpl createPresenter() {
        return new ItemFragmentPrenImpl(this);
    }



    public void setIndex(String find_id) {
        this.currentId = Integer.parseInt(find_id);
    }
    @Override
    public void setData(List<DiscoverBean> discoverBeans) {
        if(discoverBeans!=null&&discoverBeans.size()>0){
            for(int i=0 ;i<discoverBeans.size();i++){

                if (i% 5 == 3 || (i % 5 == 4)) {
                    discoverBeans.get(i).setStyle(2);
                } else {
                    discoverBeans.get(i).setStyle(1);

                }
            }
        }
      discoverAdapter.addData(discoverBeans);
    }
}
