package com.ronglian.plaza.psc.mapper;

import com.ronglian.plaza.common.entity.psc.ProductCategroy;

import java.util.List;

public interface ProductCategroyMapper {

    public List<ProductCategroy> findByCategroyTypeIn(List<Integer> categroyTypes);
}