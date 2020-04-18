package com.wfaxxdyy.mall.malluser.dao;


import com.wfaxxdyy.mallinterface.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    User getUser(String username);

    void register(User user);
}
