package com.ronglian.plaza.omc.service;

import com.ronglian.plaza.omc.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    public OrderDTO greatOreder(OrderDTO orderDTO);

    /**
     * 根据订单id查询订单
     * @param orderId
     * @return
     */
    public OrderDTO finishOrder(String orderId);

    /**
     * 查询所有的订单
     * @return
     */
    public List<OrderDTO> list();

    /**
     * 根据orderId查询order
     * @param orderId
     * @return
     */
    public OrderDTO findByOrderId(String orderId);

}
