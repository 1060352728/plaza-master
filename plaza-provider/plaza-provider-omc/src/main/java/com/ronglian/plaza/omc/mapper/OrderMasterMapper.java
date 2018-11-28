package com.ronglian.plaza.omc.mapper;

import com.ronglian.plaza.common.entity.omc.OrderMaster;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMasterMapper {

    /**
     * 根据订单id查询订单
     * @param orderId
     * @return
     */
    public OrderMaster findById(String orderId);

    /**
     * 保存订单
     * @param orderMaster
     */
    public void saveOrderMaster(OrderMaster orderMaster);

    /**
     * 修改订单的状态为已完结
     * @param orderId
     */
    public void finish(@Param("orderId") String orderId, @Param("orderStatus")Integer orderStatus);

    /**
     * 查询所有的订单
     * @return
     */
    public List<OrderMaster> list();

}