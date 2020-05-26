package com.wfaxxdyy.mallinterface.service;


import com.wfaxxdyy.mallinterface.bean.Address;
import com.wfaxxdyy.mallinterface.bean.CartBean;
import com.wfaxxdyy.mallinterface.bean.Order;
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
    void delCartBean(String username, int p_id);


    /*
    * 改变购物车商品数量
    * */
    void editCart(String username, int p_id, int productNum);


    //添加收货地址
    void addAddress(String username, Address address);

    //获取地址集合
    List<Address> getAddressList(String username);

    //更新地址
    void updateAddress(String username, Address address);

    //删除地址
    void delAddress(String username, int a_id);

    //提交订单
    int submitOrder(String username, Order order);

    //获取订单
    Order getOrder(String username, String o_id);
}
