package com.ronglian.plaza.omc.mapper;

import com.ronglian.plaza.common.entity.omc.OrderDetail;

import java.util.List;

public interface OrderDetailMapper {

    /**
     * 保存订单详情信息
     * @param orderDetail
     */
    public void saveOrderDetail(OrderDetail orderDetail);

    /**
     * 根据orderid查询订单详情
     * @param orderId
     * @return
     */
    public List<OrderDetail> findOrderDetailsByOrderId(String orderId);

    /**
     * 根据orderids查询有的订单详情
     * @param orderIds
     * @return
     */
    public List<OrderDetail> findByOrderIdIn(List<String> orderIds);

}