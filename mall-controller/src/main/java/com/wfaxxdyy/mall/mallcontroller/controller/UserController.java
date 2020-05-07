package com.wfaxxdyy.mall.mallcontroller.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.wfaxxdyy.mallinterface.bean.User;
import com.wfaxxdyy.mallinterface.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Reference
    UserService userService;

    /*
    * 校验：根据username查询用户信息
    * */
    @CrossOrigin(origins = "*", maxAge = 3600,allowCredentials="true")
    @RequestMapping("/login")
    @ResponseBody
    public User find(@RequestParam("username") String username, HttpSession session){
        User user = userService.getUser(username);
        if(user==null){
            return null;
        }

        session.setAttribute("user",user);

        return user;
    }

    /*
    * 注册
    * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping("/register")
    @ResponseBody
    public String register(@RequestBody User user){
        userService.register(user);

        return "注册成功！";
    }


    /*
    * 获取session用户对象
    * */
    @CrossOrigin(origins = "*", allowCredentials="true")
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public User getUserInfo(HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user==null){
            return null;
        }
        return user;
    }

    /*
    * 注销session用户
    * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping("/delUserInfo")
    @ResponseBody
    public void delUserInfo(HttpSession session){
        session.invalidate();
    }

}
