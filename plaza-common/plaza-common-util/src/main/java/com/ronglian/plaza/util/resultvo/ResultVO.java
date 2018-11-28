package com.ronglian.plaza.util.resultvo;

import lombok.Data;

/**
 * Created by likui
 * 2018-10-9 20:04
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;
}
