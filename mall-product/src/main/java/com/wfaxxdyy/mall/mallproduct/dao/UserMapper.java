package com.wfaxxdyy.mall.mallproduct.dao;


import com.wfaxxdyy.mallinterface.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<User> getUser();
}
