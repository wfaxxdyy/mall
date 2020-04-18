package com.wfaxxdyy.mall.mallcontroller.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.wfaxxdyy.mallinterface.bean.User;
import com.wfaxxdyy.mallinterface.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Reference
    UserService userService;

    /*
    * 校验：根据username查询用户信息
    * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping("/login")
    @ResponseBody
    public User find(@RequestParam("username") String username){
        User user = userService.getUser(username);
        if(user==null){
            return null;
        }
        return user;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping("/register")
    @ResponseBody
    public String register(@RequestBody User user){
        userService.register(user);

        return "注册成功！";
    }



}
