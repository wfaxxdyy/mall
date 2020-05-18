package com.wfaxxdyy.mall.mallproduct.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wfaxxdyy.mall.mallproduct.dao.ProductMapper;
import com.wfaxxdyy.mallinterface.bean.PageBean;
import com.wfaxxdyy.mallinterface.bean.PageBeanFront;
import com.wfaxxdyy.mallinterface.bean.Product;
import com.wfaxxdyy.mallinterface.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Service
@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getProductByCategory(int p_category) {
        return productMapper.getProductByCategory(p_category);
    }

    @Override
    public PageBeanFront findByPage(PageBean pageBean) {


        int pageNum = pageBean.getPageNum();
        int pageSize = pageBean.getPageSize();

        PageHelper.startPage(pageNum , pageSize);

        PageBeanFront pageBeanFront = new PageBeanFront();
        //得到数据
        List<Product> productList = productMapper.findByPage(pageBean);
        //得到分页的结果对象
        PageInfo<Product> productPageInfo = new PageInfo<>(productList);
        //得到分页中的Product条目对象
        List<Product> pageList = productPageInfo.getList();

        int total = (int) productPageInfo.getTotal();

        pageBeanFront.setProduct(pageList);
        pageBeanFront.setTotal(total);

        return pageBeanFront;

    }

    @Override
    public Product getProductById(int p_id) {
        return productMapper.getProductById(p_id);
    }


}
