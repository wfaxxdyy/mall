package com.wfaxxdyy.mallinterface.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/*
* `p_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `p_name` varchar(100) NOT NULL COMMENT '商品名称',
  `p_money` decimal(10,2) NOT NULL COMMENT '商品价格',
  `p_image` varchar(100) NOT NULL COMMENT '商品图片地址',
  `p_weight` double NOT NULL COMMENT '商品重量',
  `p_describe` varchar(100) NOT NULL COMMENT '商品描述',
  `p_category` int(10) NOT NULL COMMENT '商品类别',
  PRIMARY KEY (`p_id`)
* */

public class Product implements Serializable {

    private int p_id;
    private String p_name;
    private BigDecimal p_money;
    private String p_image;
    private String p_weight;
    private String p_describe;
    private String p_category;

    @Override
    public String toString() {
        return "Product{" +
                "p_id=" + p_id +
                ", p_name='" + p_name + '\'' +
                ", p_money=" + p_money +
                ", p_image='" + p_image + '\'' +
                ", p_weight='" + p_weight + '\'' +
                ", p_describe='" + p_describe + '\'' +
                ", p_category='" + p_category + '\'' +
                '}';
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public BigDecimal getP_money() {
        return p_money;
    }

    public void setP_money(BigDecimal p_money) {
        this.p_money = p_money;
    }

    public String getP_image() {
        return p_image;
    }

    public void setP_image(String p_image) {
        this.p_image = p_image;
    }

    public String getP_weight() {
        return p_weight;
    }

    public void setP_weight(String p_weight) {
        this.p_weight = p_weight;
    }

    public String getP_describe() {
        return p_describe;
    }

    public void setP_describe(String p_describe) {
        this.p_describe = p_describe;
    }

    public String getP_category() {
        return p_category;
    }

    public void setP_category(String p_category) {
        this.p_category = p_category;
    }
}
