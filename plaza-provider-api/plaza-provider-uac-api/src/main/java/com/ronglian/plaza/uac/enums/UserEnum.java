package com.ronglian.plaza.uac.enums;

import lombok.Getter;

/**
 * @author likui
 * @Classname: UserEnum
 * @Description: 用户枚举
 * @create 2018-11-16 17:47
 **/
@Getter
public enum UserEnum {

    INEXIST_ENCE(401, "用户不存在");

    private Integer code;

    private String message;

    UserEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
