package com.wfaxxdyy.mall.mallcontroller.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wfaxxdyy.mallinterface.bean.CartBean;
import com.wfaxxdyy.mallinterface.bean.User;
import com.wfaxxdyy.mallinterface.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {


    @Reference
    OrderService orderService;

    /*
    * 将商品添加到购物车
    * */
    @CrossOrigin(origins = "*", maxAge = 3600,allowCredentials="true")
    @RequestMapping("/addCart")
    @ResponseBody
    public String addCart(CartBean cartBean, HttpSession session){
        
        User user = (User) session.getAttribute("user");

        if(user!=null){
            orderService.addCart(user.getUsername(),cartBean);
        }
        return null;
    }

    /*
    * 取出购物车列表
   * */
    @CrossOrigin(origins = "*", maxAge = 3600,allowCredentials="true")
    @RequestMapping("/getCartList")
    @ResponseBody
    public List<CartBean> getCartList(HttpSession session){

        User user = (User) session.getAttribute("user");
        List<CartBean> cartList = orderService.getCartList(user.getUsername());
        if(cartList!=null){
            return cartList;
        }
        return  null;
    }

}
