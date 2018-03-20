package com.zhss.sjlm.bean;

/**
 * Created by Administrator on 2018/3/20.
 */

public class UpBean {
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankIdcard() {
        return bankIdcard;
    }

    public void setBankIdcard(String bankIdcard) {
        this.bankIdcard = bankIdcard;
    }

    public String getBankTip() {
        return bankTip;
    }

    public void setBankTip(String bankTip) {
        this.bankTip = bankTip;
    }

    private String bankName;
    private String bankIdcard;
    private String bankTip;
}
