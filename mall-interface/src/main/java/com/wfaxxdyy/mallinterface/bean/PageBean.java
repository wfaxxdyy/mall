package com.wfaxxdyy.mallinterface.bean;

import java.io.Serializable;

public class PageBean implements Serializable {

    /*
     let data = {
      sort: this.sort,
      priceGt: this.min,
      priceLte: this.max,
      pageNum : this.currentPage,
      pageSize : this.pageSize
    }
     */
    private String sort;
    private String priceGt;
    private String priceLte;
    private int pageNum;
    private int pageSize;

    @Override
    public String toString() {
        return "PageBean{" +
                "sort='" + sort + '\'' +
                ", priceGt='" + priceGt + '\'' +
                ", priceLte='" + priceLte + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getPriceGt() {
        return priceGt;
    }

    public void setPriceGt(String priceGt) {
        this.priceGt = priceGt;
    }

    public String getPriceLte() {
        return priceLte;
    }

    public void setPriceLte(String priceLte) {
        this.priceLte = priceLte;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
