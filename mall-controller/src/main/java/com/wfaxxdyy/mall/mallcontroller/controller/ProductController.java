package com.wfaxxdyy.mall.mallcontroller.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.wfaxxdyy.mall.mallcontroller.util.RedisDBChangeUtil;
import com.wfaxxdyy.mallinterface.bean.PageBean;
import com.wfaxxdyy.mallinterface.bean.PageBeanFront;
import com.wfaxxdyy.mallinterface.bean.Product;
import com.wfaxxdyy.mallinterface.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
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

    @Autowired
    RedisDBChangeUtil redisDBChangeUtil;

    @Autowired
    @Qualifier("productRedisTemplate")
    private RedisTemplate prt;

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

        redisDBChangeUtil.setDataBase(1);
        Product redisProduct = (Product) prt.opsForValue().get(Integer.toString(p_id));
        if(null!=redisProduct){
            return redisProduct;
        }else {
            Product product = productService.getProductById(p_id);
            prt.opsForValue().set(Integer.toString(p_id),product);
            return product;
        }
    }

    @CrossOrigin(origins = "*", maxAge = 3600, allowCredentials="true")
    @RequestMapping("/findByPage")
    @ResponseBody
    public PageBeanFront findByPage(PageBean pageBean){

        return productService.findByPage(pageBean);

    }


}
