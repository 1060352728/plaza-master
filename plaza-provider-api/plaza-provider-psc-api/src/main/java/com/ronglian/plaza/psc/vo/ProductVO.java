package com.ronglian.plaza.psc.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @methord:  产品类目返回结果封装类
 * @author： likui
 * @great： 2018/10/8 22:40
 */
@Data
public class ProductVO {

    @ApiModelProperty(value = "产品类目名")
    @JsonProperty("name")
    private String categroyName;

    @ApiModelProperty(value = "产品类型")
    @JsonProperty("type")
    private Integer categroyType;

    @ApiModelProperty(value = "该类目下的产品集合")
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;//该类目下的产品集合

}
