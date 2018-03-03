package com.zhss.sjlm.ui.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhss.sjlm.R;
import com.zhss.sjlm.bean.DiscoverBean;
import com.zhss.sjlm.common.Contacts;
import com.zhss.sjlm.tools.GlideManager;

/**
 * Created by win7-64 on 2018/1/29.
 */

public class DiscoverAdapter extends BaseMultiItemQuickAdapter<DiscoverBean,BaseViewHolder> {



    public DiscoverAdapter(){
        super(null);
        addItemType(Contacts.TYPE_DISCOVER_ONE_IMG, R.layout.hor_item);
        addItemType(Contacts.TYPE_DISCOVER_MULTI_IMG, R.layout.ver_item);
    }



    @Override
    protected void convert(BaseViewHolder helper, DiscoverBean item) {
        switch (helper.getItemViewType()){
            case Contacts.TYPE_DISCOVER_ONE_IMG:
                System.out.println("adddress1"+item.getLive_store_address());
                helper.setText(R.id.food_address,item.getLive_store_address())
                        .setText(R.id.food_name,item.getStore_name());
                GlideManager.loadImage(mContext,item.getStore_image(),(ImageView) helper.getView(R.id.foot_img));
            case Contacts.TYPE_DISCOVER_MULTI_IMG:
                System.out.println("address2"+item.getLive_store_address());
                helper.setText(R.id.ver_distance,item.getLive_store_address())
                        .setText(R.id.ver_name,item.getStore_name());
                GlideManager.loadImage(mContext,item.getStore_image(),(ImageView) helper.getView(R.id.ver_img));


        }
    }
   /* private Context context;
    private final int TYPE1 = 1;
    private final int TYPE2 = 2;
    private final LayoutInflater inflater;
    private List<DiscoverBean> dataList;

    public DiscoverAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE1:
                View viewOne = inflater.inflate(R.layout.hor_item, parent, false);
                return new OneViewHolder(viewOne);
            case TYPE2:
                View viewTwo = inflater.inflate(R.layout.ver_item, parent, false);
                return new TwoViewHolder(viewTwo);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {

            case TYPE1:
                System.out.println("typ1==="+position);
                Glide.with(context)
                        .load(dataList.get(position).getStore_image())
                        .into(((OneViewHolder) holder).oneImg);
                ((OneViewHolder) holder).oneAddres.setText(dataList.get(position).getLive_store_address());
                ((OneViewHolder) holder).oneName.setText(dataList.get(position).getStore_name());
                break;
            case TYPE2:
                System.out.println("typ2==="+position);
                Glide.with(context)
                        .load(dataList.get(position).getStore_image())
                        .into(((TwoViewHolder) holder).twoImg);
                ((TwoViewHolder) holder).twoAdd.setText(dataList.get(position).getLive_store_address());
                ((TwoViewHolder) holder).twoName.setText(dataList.get(position).getStore_name());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position% 5 == 3 || (position % 5 == 4)) {
            System.out.println("pos"+position);

            return TYPE2;
        } else {
            return TYPE1;
        }

    }

    public void setData(List<DiscoverBean> dataList) {
        this.dataList = dataList;
    }

    class OneViewHolder extends RecyclerView.ViewHolder {

        ImageView oneImg;
        TextView oneName;
        TextView oneAddres;

        public OneViewHolder(View itemView) {
            super(itemView);
            oneImg = itemView.findViewById(R.id.foot_img);
            oneName = itemView.findViewById(R.id.food_name);
            oneAddres = itemView.findViewById(R.id.food_address);
        }
    }

    class TwoViewHolder extends RecyclerView.ViewHolder {

        ImageView twoImg;
        TextView twoAdd;
        TextView twoName;

        public TwoViewHolder(View itemView) {
            super(itemView);
            twoImg = itemView.findViewById(R.id.ver_img);
            twoAdd = itemView.findViewById(R.id.ver_distance);
            twoName = itemView.findViewById(R.id.ver_name);
        }
    }*/
}
