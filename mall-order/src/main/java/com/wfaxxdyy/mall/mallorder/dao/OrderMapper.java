package com.wfaxxdyy.mall.mallorder.dao;

import com.wfaxxdyy.mallinterface.bean.CartBean;
import com.wfaxxdyy.mallinterface.bean.UserCartBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    //添加商品到购物车
    void addCart(UserCartBean userCartBean);

    //获取购物车
    List<CartBean> getCartList(String username);

    //更新购物车
    void updateCartList(String username, String p_name);
}
