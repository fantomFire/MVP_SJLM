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
      //  mStateView = StateView.inject(flContent);
      //  mStateView.showLoading();
        recDiscover.setLayoutManager(new LinearLayoutManager(mActivity));
        discoverAdapter = new DiscoverAdapter();
        recDiscover.setAdapter(discoverAdapter);

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_item;
    }

    @Override
    public void initdis() {
        System.out.println("currentId33333"+currentId);
        mPresenter.getData(currentId);
    }

    @Override
    protected void initData() {


    }

    @Override
    public ItemFragmentPrenImpl createPresenter() {
        return new ItemFragmentPrenImpl(this);
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
        System.out.println("find_id1111"+find_id);
        this.currentId = Integer.parseInt(find_id);
        System.out.println("find_id222"+currentId);
    }
    @Override
    public void setData(List<DiscoverBean> discoverBeans) {
        if(discoverBeans!=null&&discoverBeans.size()>0){
            for(int i=0 ;i<discoverBeans.size();i++){

                if (i% 5 == 3 || (i % 5 == 4)) {
                    System.out.println("pos"+i);

                   discoverBeans.get(i).setStyle(1);
                } else {
                    discoverBeans.get(i).setStyle(2);
                }
            }
        }
      discoverAdapter.addData(discoverBeans);
       // discoverAdapter.notifyDataSetChanged();




    }
}
