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
    public String find(){
        List<User> userList = orderService.getUser();

        String str=null;
        for (User user : userList) {
            str+=user.getName();
        }

        return str;
    }

}
