package com.ronglian.plaza.uac.enums;

import lombok.Getter;

/**
 * Created by likui
 * 2018-10-10 17:32
 */
@Getter
public enum LoginResultEnum {

    LOGIN_FAIL(1, "登录失败"),
    ROLE_ERROR(2, "角色不正确")
    ;

    private Integer code;

    private String message;

    LoginResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
