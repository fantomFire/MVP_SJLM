package com.zhss.sjlm.ui.fragment;

import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import com.zhss.sjlm.R;
import com.zhss.sjlm.base.BaseMvpFragment;
import com.zhss.sjlm.bean.LoginBean;
import com.zhss.sjlm.present.ItemFragmentPrenImpl;
import com.zhss.sjlm.ui.contact.DiscoverItemContact;

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
    private String currentId;


    @Override
    protected void initView() {
      //  mStateView = StateView.inject(flContent);
      //  mStateView.showLoading();

       /* LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recDiscover.setLayoutManager(linearLayoutManager);
        discoverAdapter = new DiscoverAdapter(getActivity());
        recDiscover.setAdapter(discoverAdapter);*/

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_item;
    }

    @Override
    protected void initData() {

    }

    @Override
    public ItemFragmentPrenImpl createPresenter() {
        return null;
    }

   /* @Override
    public DiscocerItemPresent createPresenter() {
        return new DiscocerItemPresent();
    }

    @Override
    public void loadSuccess(Object data) {
        DiscoverBean datas = (DiscoverBean)data;
        if(datas.getStatus().equals("200")){
          //  mStateView.showContent();
            dataList = datas.getMsg();
            System.out.println("数据"+datas.toString());
            discoverAdapter.setData(dataList);
            discoverAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void loadFail(Object data) {
        Toast.makeText(mContext, data.toString(), Toast.LENGTH_SHORT).show();
    }
*/


    public void setIndex(String find_id) {
        currentId = find_id;
    }
/*

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("item+"+currentId);
        getPresenter().getDiscoverItemData(currentId);
    }
*/

    @Override
    public void setData(LoginBean dataList) {

    }
}
