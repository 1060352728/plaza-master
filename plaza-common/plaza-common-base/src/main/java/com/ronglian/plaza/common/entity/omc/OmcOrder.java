package com.ronglian.plaza.common.entity.omc;

import lombok.Data;

@Data
public class OmcOrder {

    private Integer orderId;

    private String orderName;

    private String orderContent;

    private String orderIsused;

    private Integer memberId;

}