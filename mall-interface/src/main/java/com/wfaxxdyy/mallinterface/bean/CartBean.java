package com.wfaxxdyy.mallinterface.bean;

import java.io.Serializable;
import java.math.BigDecimal;


public class CartBean implements Serializable {

  private String p_name;
  private String p_image;
  private BigDecimal p_money;

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
}
