package com.ronglian.plaza.psc.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @methord:  返回结果封装类
 * @author： likui
 * @great： 2018/10/8 22:40
 */
@Data
public class ResultVO<T> {

    /**
     * 错误码
     */
    @ApiModelProperty(value = "返回码")
    private Integer code;

    /**
     * 提示信息
     */
    @ApiModelProperty(value = "返回提示信息")
    private String msg;

    /**
     * 具体内容
     */
    @ApiModelProperty(value = "返回数据")
    private T data;
}
