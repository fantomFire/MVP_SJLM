package com.zhss.sjlm.bean;

/**
 * Created by Administrator on 2018/3/19.
 */

public class User {

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    private String bankName;
    private String bankCard;
}
