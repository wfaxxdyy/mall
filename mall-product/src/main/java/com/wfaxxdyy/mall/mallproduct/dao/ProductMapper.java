package com.wfaxxdyy.mall.mallproduct.dao;

import com.wfaxxdyy.mallinterface.bean.PageBean;
import com.wfaxxdyy.mallinterface.bean.PageBeanFront;
import com.wfaxxdyy.mallinterface.bean.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {

    List<Product> getProductByCategory(int p_category);

    List<Product> findByPage(PageBean pageBean);

    Product getProductById(int p_id);
}
