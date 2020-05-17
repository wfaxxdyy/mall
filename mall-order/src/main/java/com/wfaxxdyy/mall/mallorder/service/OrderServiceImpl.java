package com.wfaxxdyy.mall.mallorder.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.wfaxxdyy.mall.mallorder.dao.OrderMapper;
import com.wfaxxdyy.mallinterface.bean.CartBean;
import com.wfaxxdyy.mallinterface.bean.UserCartBean;
import com.wfaxxdyy.mallinterface.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Service
@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    /*
    * 添加购物车
    * */
    @Override
    public void addCart(String username, CartBean cartBean) {

        //封装数据，主要添加username这个参数
        UserCartBean userCartBean = new UserCartBean();
        userCartBean.setUsername(username);
        userCartBean.setP_name(cartBean.getP_name());
        userCartBean.setP_money(cartBean.getP_money());
        userCartBean.setP_image(cartBean.getP_image());
        userCartBean.setProductNum(cartBean.getProductNum());

        List<CartBean> cartList = orderMapper.getCartList(username);
        String p_name = cartBean.getP_name();

        //判断是否存在购物车
        if(cartList==null){
            orderMapper.addCart(userCartBean);
        }else {
            int i=0;
            for (CartBean item: cartList) {
                i++;
                if(item.getP_name().equals(p_name)){
                    orderMapper.updateCartList(username,p_name);
                    break;
                }
            }
            if(i==cartList.size()){
                orderMapper.addCart(userCartBean);
            }
        }

    }

    /*
    * 获取购物车
    * */
    @Override
    public List<CartBean> getCartList(String username) {

        return orderMapper.getCartList(username);
    }



}
