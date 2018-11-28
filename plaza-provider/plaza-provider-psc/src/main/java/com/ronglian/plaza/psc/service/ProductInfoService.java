package com.ronglian.plaza.psc.service;

import com.ronglian.plaza.common.entity.psc.ProductInfo;
import com.ronglian.plaza.common.entity.psc.ProductInfoOutput;
import com.ronglian.plaza.psc.common.DecreaseStockInput;

import java.util.List;

public interface ProductInfoService {

    /**
     * 根据产品的状态查询在架的产品
     * @return
     */
    public List<ProductInfo> findByProductStatus(Integer productStatus);

    public List<ProductInfoOutput> findByProductIdIn(List<String> productIdList);

    /**
     * 扣库存
     * @param decreaseStockInputList
     */
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);

}
