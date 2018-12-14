package com.ronglian.plaza.omc.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ronglian.plaza.omc.dto.OrderDTO;
import com.ronglian.plaza.omc.enums.ResultEnum;
import com.ronglian.plaza.omc.form.OrderForm;
import com.ronglian.plaza.omc.vo.ResultVOUtil;
import com.ronglian.plaza.omc.vo.ResultVO;
import com.ronglian.plaza.omc.converter.OrderDTOConverter;
import com.ronglian.plaza.omc.exception.OrderException;
import com.ronglian.plaza.omc.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author likui
 * @Classname: OrderController
 * @Description: 订单控制器
 * @create 2018-09-26 16:55
 **/
@RestController
@RequestMapping("/order")
@Slf4j
@DefaultProperties(defaultFallback = "defaultFallBack")    //开启服务降级默认调用方法
public class OrderController {

    @Autowired
    OrderService orderService;

    /**  
     * @methord: creatOrder
     * @author： likui
     * @great： 2018/10/9 13:19  
     * @param： []  
     * @return： void  
     * @throws:
     * 1. 参数检验
     * 2. 查询商品信息(调用商品服务)
     * 3. 计算总价
     * 4. 扣库存(调用商品服务)
     * 5. 订单入库
     */ 
    @PostMapping("/creat")
    public ResultVO<Map<String, String>> creatOrder(@Valid OrderForm orderForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确, orderForm={}", orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车信息为空");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }
        //保存订单信息
        OrderDTO order = orderService.greatOreder(orderDTO);
        Map<String, String> map = new HashMap<>();
        map.put("orderId", order.getOrderId());
        return ResultVOUtil.success(map);
    }

    /**
     * 完结订单操作
     * @param orderId
     * @return
     */
    @RequestMapping("/finish")
    public ResultVO<OrderDTO> finish(@RequestParam("orderId")String orderId){
        OrderDTO orderDTO = orderService.finishOrder(orderId);
        return ResultVOUtil.success(orderDTO);
    }

    /**
     * 查询所有的订单，测试默认超时配置
     * @return
     */
    @HystrixCommand
    @GetMapping("/list")
    public ResultVO<OrderDTO> list(){
        return ResultVOUtil.success(orderService.list());
    }


    /**
     * 测试Hystrix熔断机制并调用指定的错误回调方法，不再是是默认的提示信息了
     * @return
     */
    @HystrixCommand(fallbackMethod = "findByIdfallBack",
            commandProperties = {
                @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //开启断路器
                @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),  //断路器最小请求数
                @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //断路器处于半开放状态，会在10秒内进行重试
                @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),  //错误率达到60%以上会启动熔断机制
    })
    @GetMapping("/findbyid")
    public ResultVO<OrderDTO> findByOrderId(@RequestParam("orderId")String orderId){
        /*if(orderId==1){
            try {
                Thread.sleep(2000);
            } catch (Exception e) {

            }
        }*/
        return ResultVOUtil.success(orderService.findByOrderId(orderId));
    }



    /**
     * 服务超时默认选择降级的方法
     * @return
     */
    public ResultVO<OrderDTO> defaultFallBack(){
        log.info("访问/list接口服务超时，返回默认超时提示");
        return ResultVOUtil.error(403,"默认提示，网络开小差了，请稍后重试");
    }

    /**
     * findByOrderId该方法指定的错误回调方法，
     * 注意，原方法上有参数，服务降级参数也必须有（坑）
     * @return
     */
    public ResultVO<OrderDTO> findByIdfallBack(String orderId){
        log.info("访问/findbyid参数orderId{}"+orderId+"时接口服务出现容错，该系统已启动服务的保护机制");
        return ResultVOUtil.error(403,"根据订单编号查询订单信息由于网络问题导致失败，请重试");
    }
}
