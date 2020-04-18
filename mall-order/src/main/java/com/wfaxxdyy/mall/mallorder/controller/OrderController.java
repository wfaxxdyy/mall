package com.wfaxxdyy.mall.mallorder.controller;



import com.wfaxxdyy.mallinterface.bean.User;
import com.wfaxxdyy.mallinterface.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/user")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/find")
    @ResponseBody
    public String find(String username){
        User user = orderService.getUser(username);

        return user.toString();
    }

}
