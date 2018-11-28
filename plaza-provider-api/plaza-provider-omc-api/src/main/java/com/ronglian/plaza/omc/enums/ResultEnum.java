package com.ronglian.plaza.omc.enums;

import lombok.Getter;

/**
 * Created by likui
 * 2018-10-10 17:32
 */
@Getter
public enum ResultEnum {

    PARAM_ERROR(1, "参数错误"),
    CART_EMPTY(2, "购物车为空"),
    ORDER_NOT_EXIST(3,"订单不存在"),
    ORDER_STATUS_ERROR(4,"订单状态错误");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
