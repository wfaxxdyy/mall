package com.wfaxxdyy.mall.mallorder.dao;

import com.wfaxxdyy.mallinterface.bean.Address;
import com.wfaxxdyy.mallinterface.bean.CartBean;
import com.wfaxxdyy.mallinterface.bean.Order;
import com.wfaxxdyy.mallinterface.bean.UserCartBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    //添加商品到购物车
    void addCart(UserCartBean userCartBean);

    //获取购物车
    List<CartBean> getCartList(String username);

    //更新购物车
    void updateCartList(String username, String p_name, int productNum);

    //删除购物车商品
    void delCartBean(String username, int p_id);

    //更改购物车商品数量
    void editCart(String username, int p_id, int productNum);

    //添加收货地址
    void addAddress(@Param("username") String username, @Param("address") Address address);

    //获取地址集合
    List<Address> getAddressList(String username);

    //更新地址
    void updateAddress(@Param("username") String username, @Param("address") Address address);

    //删除地址
    void delAddress(String username, int a_id);

    //提交订单
    int submitOrder(@Param("username") String username, @Param("order") Order order);

    //获取订单
    Order getOrder(String username, String o_id);
}
