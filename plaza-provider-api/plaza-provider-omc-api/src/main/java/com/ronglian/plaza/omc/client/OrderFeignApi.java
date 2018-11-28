package com.ronglian.plaza.omc.client;

/*import OmcOrder;
import com.ronglian.plaza.omc.hystrix.OrderFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@FeignClient(name = "plaza-provider-omc",fallback = OrderFeignHystrix.class)*/
public interface OrderFeignApi {

    /*
     * @methord: findOrdersByMemberId  主语事项，不能使用ｇｅｔ请求，否则降级不能起作用
     * @author： likui
     * @great： 2018/9/30 10:57
     * @param： [memberId]
     * @return： java.util.Map<java.lang.String,java.lang.Object>
     * @throws:
     *//**//*
    @PostMapping("/order/findOrdersByMemberId/{memberId}")
    public List<OmcOrder> findOrdersByMemberId(@RequestParam("memberId") Integer memberId);*/
}
