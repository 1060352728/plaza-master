package com.ronglian.plaza.psc.exception;

import com.ronglian.plaza.psc.enums.ResultEnum;

/**
 * @author likui
 * @Classname: ProductException
 * @Description: 自定义产品异常类
 * @create 2018-10-30 12:42
 **/
public class ProductException extends RuntimeException {

    private Integer code;

    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
