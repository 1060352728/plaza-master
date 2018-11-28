package com.ronglian.plaza.common.entity.omc;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderMaster {

    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    private Integer orderStatus;

    private Integer payStatus;

    private Date createTime;

    private Date updateTime;

}