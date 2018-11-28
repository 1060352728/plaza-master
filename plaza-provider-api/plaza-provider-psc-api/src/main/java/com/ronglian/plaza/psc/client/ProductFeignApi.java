package com.ronglian.plaza.psc.client;

import com.ronglian.plaza.common.entity.psc.ProductInfoOutput;
import com.ronglian.plaza.psc.common.DecreaseStockInput;
import com.ronglian.plaza.psc.hystrix.ProductFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "plaza-provider-psc",fallback = ProductFeignHystrix.class)
public interface ProductFeignApi {

    @PostMapping("/product/listForOrder")
    public List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);

    /**
     * 扣库存
     * @param decreaseStockInputList
     */
    @PostMapping("/product/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);
}
