package com.wfaxxdyy.mall.mallcontroller.controller;

import com.wfaxxdyy.mallinterface.bean.CartBean;
import com.wfaxxdyy.mallinterface.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {


    @CrossOrigin(origins = "*", maxAge = 3600,allowCredentials="true")
    @RequestMapping("/addCart")
    @ResponseBody
    public String addCart(CartBean cartBean, HttpSession session){

        User user = (User) session.getAttribute("user");

        if(user!=null){
            List<CartBean> cartList = (List<CartBean>) session.getAttribute("cartList");
            if(cartList==null){
                 cartList = new ArrayList<>();
                 cartList.add(cartBean);
                 session.setAttribute("cartList",cartList);
            }else {
                cartList.add(cartBean);
                session.setAttribute("cartList",cartList);
            }
            return "add success!";
        }
        return null;
    }

    @CrossOrigin(origins = "*", maxAge = 3600,allowCredentials="true")
    @RequestMapping("/getCartList")
    @ResponseBody
    public List<CartBean> getCartList(HttpSession session){
        List<CartBean> cartList = (List<CartBean>) session.getAttribute("cartList");
        if(cartList==null){
            return null;
        }
        return  cartList;
    }

}
