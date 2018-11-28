package com.ronglian.plaza.uac.enums;

import lombok.Getter;

/**
 * Created by likui
 * 2018-10-10 17:32
 */
@Getter
public enum LogoutResultEnum {

    LOGOUT_SUCCESS(1, "注销成功"),
    LOGOUT_ERROR(2, "注销失败")
    ;

    private Integer code;

    private String message;

    LogoutResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
