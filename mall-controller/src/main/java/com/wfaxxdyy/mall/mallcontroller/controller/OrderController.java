package com.wfaxxdyy.mall.mallcontroller.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wfaxxdyy.mallinterface.bean.Address;
import com.wfaxxdyy.mallinterface.bean.CartBean;
import com.wfaxxdyy.mallinterface.bean.Order;
import com.wfaxxdyy.mallinterface.bean.User;
import com.wfaxxdyy.mallinterface.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    /*
    * 根据id删除购物车商品
    * */
    @CrossOrigin(origins = "*", maxAge = 3600,allowCredentials="true")
    @RequestMapping("/delCartBean")
    public void delCartBean(int p_id, HttpSession session){
        User user = (User) session.getAttribute("user");
        orderService.delCartBean(user.getUsername(),p_id);
    }

    /*
    * 改变购物车商品数量
    * */
    @CrossOrigin(origins = "*", maxAge = 3600,allowCredentials="true")
    @RequestMapping("/editCart")
    public void editCart(int p_id, int productNum, HttpSession session){
        User user = (User) session.getAttribute("user");
        orderService.editCart(user.getUsername(),p_id,productNum);
    }

    /*
    * 添加地址
    * */
    @CrossOrigin(origins = "*", maxAge = 3600,allowCredentials="true")
    @RequestMapping("/addAddress")
    public void addAddress(Address address, HttpSession session){
        User user = (User) session.getAttribute("user");
        orderService.addAddress(user.getUsername(), address);
    }

    /*
    * 获取地址集合
    * */
    @CrossOrigin(origins = "*", maxAge = 3600,allowCredentials="true")
    @RequestMapping("/getAddressList")
    @ResponseBody
    public List<Address> getAddressList(HttpSession session){

        User user = (User) session.getAttribute("user");
        if(user!=null){
            return orderService.getAddressList(user.getUsername());
        }
        return null;
    }

    //更新地址
    @CrossOrigin(origins = "*", maxAge = 3600,allowCredentials="true")
    @RequestMapping("/updateAddress")
    public void updateAddress(Address address, HttpSession session){
        User user = (User) session.getAttribute("user");
        orderService.updateAddress(user.getUsername(), address);
    }

    //删除地址
    @CrossOrigin(origins = "*", maxAge = 3600,allowCredentials="true")
    @RequestMapping("/delAddress")
    public void delAddress(int a_id, HttpSession session){
        User user = (User) session.getAttribute("user");
        orderService.delAddress(user.getUsername(),a_id);
    }

    //提交订单
    @CrossOrigin(origins = "*", maxAge = 3600,allowCredentials="true")
    @RequestMapping("/submitOrder")
    @ResponseBody
    public int submitOrder(Order order, HttpSession session){
        User user = (User) session.getAttribute("user");
        int orderId = orderService.submitOrder(user.getUsername(), order);
        return orderId;
    }

    //获取订单信息
    @CrossOrigin(origins = "*", maxAge = 3600,allowCredentials="true")
    @RequestMapping("/getOrder")
    @ResponseBody
    public Order getOrder(String o_id, HttpSession session){
        System.out.println(o_id);
        User user = (User) session.getAttribute("user");
        return orderService.getOrder(user.getUsername(),o_id);
    }
}
