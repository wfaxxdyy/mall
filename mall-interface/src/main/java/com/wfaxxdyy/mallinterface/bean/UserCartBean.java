package com.wfaxxdyy.mallinterface.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class UserCartBean implements Serializable {

    private String username;
    private int p_id;
    private String p_name;
    private String p_image;
    private BigDecimal p_money;
    private int productNum;


    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_image() {
        return p_image;
    }

    public void setP_image(String p_image) {
        this.p_image = p_image;
    }

    public BigDecimal getP_money() {
        return p_money;
    }

    public void setP_money(BigDecimal p_money) {
        this.p_money = p_money;
    }

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }
}
