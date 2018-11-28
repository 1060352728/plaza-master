package com.ronglian.plaza.common.entity.psc;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductInfo {

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer productStatus;

    private Integer categroyType;

    private Date createTime;

    private Date updateTime;

}