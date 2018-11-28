package com.ronglian.plaza.psc.common;

import lombok.Data;

/**
 * @author likui
 * @Classname: DecreaseStockInput
 * @Description: 减库存传入的参数实体类
 * @create 2018-10-30 11:41
 **/
@Data
public class DecreaseStockInput {

    private String productId;

    private Integer productQuantity;

    public DecreaseStockInput() {
    }

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
