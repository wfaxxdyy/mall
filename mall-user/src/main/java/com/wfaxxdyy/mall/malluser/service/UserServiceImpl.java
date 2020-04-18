package com.wfaxxdyy.mall.malluser.service;

import com.alibaba.dubbo.config.annotation.Service;

import com.wfaxxdyy.mall.malluser.dao.UserMapper;
import com.wfaxxdyy.mallinterface.bean.User;
import com.wfaxxdyy.mallinterface.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Service
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String username) {
        return userMapper.getUser(username);
    }

    @Override
    public void register(User user) {
        userMapper.register(user);
    }
}
