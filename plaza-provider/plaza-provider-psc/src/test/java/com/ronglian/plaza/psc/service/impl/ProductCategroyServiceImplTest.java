package com.ronglian.plaza.psc.service.impl;

import com.ronglian.plaza.PlazaProviderPscApplicationTests;
import com.ronglian.plaza.common.entity.psc.ProductCategroy;
import com.ronglian.plaza.psc.service.ProductCategroyService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public class ProductCategroyServiceImplTest extends PlazaProviderPscApplicationTests {

    @Autowired
    private ProductCategroyService productCategroyService;

    @Test
    public void findByCategroyTypeIn() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        List<ProductCategroy> resultlist = productCategroyService.findByCategroyTypeIn(list);
        Assert.assertTrue(list.size()>0);
    }
}