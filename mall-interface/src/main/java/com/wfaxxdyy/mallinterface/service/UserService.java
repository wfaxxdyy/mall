package com.wfaxxdyy.mallinterface.service;

import com.wfaxxdyy.mallinterface.bean.User;

import java.util.List;

public interface UserService {

    //根据名字获取用户信息
    User getUser(String username);

    //注册用户
    void register(User user);

    //

}
