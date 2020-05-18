package com.wfaxxdyy.mallinterface.service;


import com.wfaxxdyy.mallinterface.bean.CartBean;
import com.wfaxxdyy.mallinterface.bean.User;

import java.util.List;

public interface OrderService {

    /*
    * 根据用户添加购物车
    * */
    void addCart(String username, CartBean cartBean);

    /*
    * 获取购物车
    * */
    List<CartBean> getCartList(String username);

    /*
    * 删除购物车商品
    * */
    void delCartBean(String username,String p_name);

}
