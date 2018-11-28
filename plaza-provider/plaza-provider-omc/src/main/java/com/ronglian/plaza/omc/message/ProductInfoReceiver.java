package com.ronglian.plaza.omc.message;

import com.fasterxml.jackson.core.type.TypeReference;
import com.ronglian.plaza.common.entity.psc.ProductInfoOutput;
import com.ronglian.plaza.util.common.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author likui
 * @Classname: ProductInfoReceiver
 * @Description: 接收产品服务发送的消息
 * @create 2018-10-31 13:13
 **/
@Component
@Slf4j
public class ProductInfoReceiver {

    private static final String PRODUCT_STOCK_TEMPLATE = "product_stock_%s";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 接收消息
     * @param message
     */
    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message){
        log.info("接受到了产品服务发送的产品信息{}"+message);
        List<ProductInfoOutput> productInfoOutputList = (List<ProductInfoOutput>)JsonUtil.fromJson(message, new TypeReference<List<ProductInfoOutput>>() {});
        for (ProductInfoOutput productInfoOutput : productInfoOutputList) {
            //将产品的库存放入缓存中
            stringRedisTemplate.opsForValue().set(String.format(PRODUCT_STOCK_TEMPLATE,productInfoOutput.getProductId()),String.valueOf(productInfoOutput.getProductStock()));
        }
    }
}
