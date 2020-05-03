package com.wfaxxdyy.mallinterface.service;

import com.wfaxxdyy.mallinterface.bean.PageBean;
import com.wfaxxdyy.mallinterface.bean.PageBeanFront;
import com.wfaxxdyy.mallinterface.bean.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProductByCategory(int p_category);

    PageBeanFront findByPage(PageBean pageBean);
}
