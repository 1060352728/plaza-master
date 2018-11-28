package com.ronglian.plaza.psc.service.impl;

import com.ronglian.plaza.PlazaProviderPscApplicationTests;
import com.ronglian.plaza.common.entity.psc.ProductInfo;
import com.ronglian.plaza.psc.service.ProductInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


public class ProductInfoServiceImplTest extends PlazaProviderPscApplicationTests {

    @Autowired
    private ProductInfoService productInfoService;

    @Test
    public void findByProductStatus() {
        List<ProductInfo> list = productInfoService.findByProductStatus(0);
        Assert.assertTrue(list.size()>0);
    }
}