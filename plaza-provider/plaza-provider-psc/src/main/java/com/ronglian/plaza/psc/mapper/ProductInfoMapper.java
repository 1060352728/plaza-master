package com.ronglian.plaza.psc.mapper;

import com.ronglian.plaza.common.entity.psc.ProductInfo;
import com.ronglian.plaza.common.entity.psc.ProductInfoOutput;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductInfoMapper {

    /**
     * 根据产品的状态查询在架的产品
     * @return
     */
    public List<ProductInfo> findByProductStatus(Integer productStatus);

    public List<ProductInfo> findByProductIdIn(List<String> productIdList);

    /**
     * 根据产品编号查询产品信息
     * @param productId
     * @return
     */
    public ProductInfo findById(String productId);

    /**
     * 修改库存
     * @param productId , productStock
     */
    public void updateProductStock(@Param("productId")String productId, @Param("productStock")Integer productStock);
}