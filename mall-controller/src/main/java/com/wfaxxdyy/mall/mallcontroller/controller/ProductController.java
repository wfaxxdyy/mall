package com.wfaxxdyy.mall.mallcontroller.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.wfaxxdyy.mallinterface.bean.PageBean;
import com.wfaxxdyy.mallinterface.bean.PageBeanFront;
import com.wfaxxdyy.mallinterface.bean.Product;
import com.wfaxxdyy.mallinterface.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Reference
    ProductService productService;

    @CrossOrigin(origins = "*", maxAge = 3600, allowCredentials="true")
    @RequestMapping("/getProductByCategory")
    @ResponseBody
    public List<Product> getProductByCategory(@RequestParam("p_category") int p_category){

        return productService.getProductByCategory(p_category);

    }

    @CrossOrigin(origins = "*", maxAge = 3600, allowCredentials="true")
    @RequestMapping("/getProductById")
    @ResponseBody
    public Product getProductById(@RequestParam("p_id") int p_id){

        return productService.getProductById(p_id);

    }

    @CrossOrigin(origins = "*", maxAge = 3600, allowCredentials="true")
    @RequestMapping("/findByPage")
    @ResponseBody
    public PageBeanFront findByPage(PageBean pageBean){

        return productService.findByPage(pageBean);

    }


}
