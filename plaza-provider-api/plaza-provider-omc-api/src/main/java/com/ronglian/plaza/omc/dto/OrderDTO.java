package com.ronglian.plaza.omc.dto;

import com.ronglian.plaza.common.entity.omc.OrderDetail;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author： likui
 * @great： 2018/10/8 23:41
 */ 
@Data
public class OrderDTO {

    /** 订单id. */
    private String orderId;

    /** 买家名字. */
    private String buyerName;

    /** 买家手机号. */
    private String buyerPhone;

    /** 买家地址. */
    private String buyerAddress;

    /** 买家微信Openid. */
    private String buyerOpenid;

    /** 订单总金额. */
    private BigDecimal orderAmount;

    /** 订单状态, 默认为0新下单. */
    private Integer orderStatus;

    /** 支付状态, 默认为0未支付. */
    private Integer payStatus;

    private List<OrderDetail> orderDetailList;

}
