package com.wfaxxdyy.mallinterface.bean;

import java.io.Serializable;
import java.util.List;

public class PageBeanFront implements Serializable {

    private List<Product> product;
    private int total;

    @Override
    public String toString() {
        return "PageBeanFront{" +
                "product=" + product +
                ", total=" + total +
                '}';
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
