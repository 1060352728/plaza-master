package com.ronglian.plaza.psc.service;

import com.ronglian.plaza.common.entity.psc.ProductCategroy;

import java.util.List;

/**
 * 产品类目
 */
public interface ProductCategroyService {

    public List<ProductCategroy> findByCategroyTypeIn(List<Integer> categroyTypes);
}
