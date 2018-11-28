package com.ronglian.plaza.omc.exception;


import com.ronglian.plaza.omc.enums.ResultEnum;

/**
 * Created by likui
 * 2018-10-9 19:49
 */
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
