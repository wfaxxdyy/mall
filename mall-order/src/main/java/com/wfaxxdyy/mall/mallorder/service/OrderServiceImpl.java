package com.wfaxxdyy.mall.mallorder.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.wfaxxdyy.mall.mallorder.dao.OrderMapper;
import com.wfaxxdyy.mallinterface.bean.*;
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
        userCartBean.setP_id(cartBean.getP_id());
        userCartBean.setP_name(cartBean.getP_name());
        userCartBean.setP_money(cartBean.getP_money());
        userCartBean.setP_image(cartBean.getP_image());
        userCartBean.setProductNum(cartBean.getProductNum());

        List<CartBean> cartList = orderMapper.getCartList(username);
        String p_name = cartBean.getP_name();
        int productNum = cartBean.getProductNum();

        //判断是否存在购物车
        if(cartList==null){
            orderMapper.addCart(userCartBean);
        }else {
            int i=0;
            for (CartBean item: cartList) {
                i++;
                if(item.getP_name().equals(p_name)){
                    productNum = productNum+item.getProductNum();
                    orderMapper.updateCartList(username,p_name,productNum);
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

    /*
    * 删除购物车商品
    * */
    @Override
    public void delCartBean(String username, int p_id) {

        orderMapper.delCartBean(username,p_id);

    }

    /*
     * 改变购物车商品数量
     * */
    @Override
    public void editCart(String username, int p_id, int productNum) {

        orderMapper.editCart(username,p_id,productNum);
    }

    //添加收货地址
    @Override
    public void addAddress(String username, Address address) {
        orderMapper.addAddress(username,address);
    }

    //获取地址集合
    @Override
    public List<Address> getAddressList(String username) {
        return orderMapper.getAddressList(username);
    }

    //更新地址
    @Override
    public void updateAddress(String username, Address address) {
        orderMapper.updateAddress(username,address);
    }

    //删除地址
    @Override
    public void delAddress(String username, int a_id) {
        orderMapper.delAddress(username,a_id);
    }

    //提交订单
    @Override
    public int submitOrder(String username, Order order) {
        orderMapper.submitOrder(username,order);
        return order.getO_id();
    }

    //获取订单
    @Override
    public Order getOrder(String username, String o_id) {
        return orderMapper.getOrder(username,o_id);
    }

    //清空购物车
    @Override
    public void cleanOrder(String username) {
        orderMapper.cleanOrder(username);
    }

    @Override
    public void payment(String username, PayInfo payInfo) {
        orderMapper.payment(username,payInfo);
    }


}
