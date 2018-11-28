package com.ronglian.plaza.uac.enums;

import lombok.Getter;

/**
 * Created by likui
 * 2018-10-10 17:32
 */
@Getter
public enum RoleEnum {

    BUYER(1, "买家"),
    SELLER(2,"卖家");

    private Integer code;

    private String message;

    RoleEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
