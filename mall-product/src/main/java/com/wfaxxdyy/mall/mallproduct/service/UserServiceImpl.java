package com.wfaxxdyy.mall.mallproduct.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.wfaxxdyy.mall.mallproduct.dao.UserMapper;
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
    public List<User> getUser() {
        return userMapper.getUser();
    }
}
