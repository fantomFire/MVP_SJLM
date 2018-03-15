package com.zhss.sjlm.tools;

import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;
import android.widget.Toast;

import com.lljjcoder.citypickerview.widget.CityPicker;

/**
 * Created by win7-64 on 2018/3/9.
 */

public  class Cityselect {

 private String currentCity = null;
    private String province;
    private String city;
    private String district;

    public void getCity(TextView txtAddress, Context context) {
        CityPicker cityPicker = new CityPicker.Builder(context)
                .textSize(20)
                .title("地址选择")
                .backgroundPop(0xa0000000)
                .titleBackgroundColor("#f5511e")
                .titleTextColor("#000000")
                .backgroundPop(0xa0000000)
                .confirTextColor("#000000")
                .cancelTextColor("#000000")
                .province("北京市")
                .city("北京市")
                .district("昌平区")
                .textColor(Color.parseColor("#000000"))
                .provinceCyclic(true)
                .cityCyclic(false)
                .districtCyclic(false)
                .visibleItemsCount(7)
                .itemPadding(10)
                .onlyShowProvinceAndCity(false)
                .build();
        cityPicker.show();

        //监听方法，获取选择结果
        cityPicker.setOnCityItemClickListener(new CityPicker.OnCityItemClickListener() {
            @Override
            public void onSelected(String... citySelected) {
                //省份
                province = citySelected[0];
                //城市
                city = citySelected[1];
                //区县（如果设定了两级联动，那么该项返回空）
                district = citySelected[2];

                txtAddress.setText(province+city+district);
            }

            @Override
            public void onCancel() {
                Toast.makeText(context, "已取消", Toast.LENGTH_LONG).show();
            }
        });
    }
}
