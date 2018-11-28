package com.ronglian.plaza.psc.service.impl;

import com.ronglian.plaza.common.entity.psc.ProductCategroy;
import com.ronglian.plaza.psc.mapper.ProductCategroyMapper;
import com.ronglian.plaza.psc.service.ProductCategroyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategroyServiceImpl implements ProductCategroyService {

    @Autowired
    ProductCategroyMapper productCategroyMapper;

    @Override
    public List<ProductCategroy> findByCategroyTypeIn(List<Integer> categroyTypes) {
        return productCategroyMapper.findByCategroyTypeIn(categroyTypes);
    }
}
