package com.ronglian.plaza.psc.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @methord:  产品返回结果封装类
 * @author： likui
 * @great： 2018/10/8 22:40
 */
@Data
public class ProductInfoVO {

    @ApiModelProperty(value = "产品ID")
    @JsonProperty("id")
    private String productId;

    @ApiModelProperty(value = "产品名称")
    @JsonProperty("name")
    private String productName;

    @ApiModelProperty(value = "产品单价")
    @JsonProperty("price")
    private BigDecimal productPrice;

    @ApiModelProperty(value = "产品描述")
    @JsonProperty("description")
    private String productDescription;

    @ApiModelProperty(value = "产品缩略图")
    @JsonProperty("icon")
    private String productIcon;

}
