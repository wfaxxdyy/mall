package com.wfaxxdyy.mall.mallorder.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wfaxxdyy.mallinterface.bean.User;
import com.wfaxxdyy.mallinterface.service.OrderService;
import com.wfaxxdyy.mallinterface.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Reference
    UserService userService;

    @Override
    public List<User> getUser() {

        return userService.getUser();
    }
}
