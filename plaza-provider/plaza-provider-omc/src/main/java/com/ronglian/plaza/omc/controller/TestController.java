package com.ronglian.plaza.omc.controller;

import com.ronglian.plaza.omc.dto.OrderDTO;
import com.ronglian.plaza.omc.message.StreamClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author likui
 * @Classname: TestController
 * @Description: 测试
 * @create 2018-09-17 14:01
 **/
@RestController
@RefreshScope
@Slf4j
public class TestController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private StreamClient streamClient;

    @Value("${name}")
    private  String name;
    @Value("${age}")
    private  String age;
    @Value("${version}")
    private  String version;

    @RequestMapping("/hellotest")
    public String helloTest(){
        return "你好，我是"+name+",年龄："+age+"岁。当前环境："+version;
    }

    /**
     * 单纯的发送消息队列
     */
    @RequestMapping("/sendmessage")
    public void sendMessage(){
        amqpTemplate.convertAndSend("myQueue","now"+new Date());
    }
    /**
     * 单纯的接收消息队列
     */
    @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    public void saveMessage(String message){
        log.info("接收到消息{}"+message);
    }

    /**
     * 消息分组
     */
    @RequestMapping("/sendtypemessage/{type}")
    public void sendTypeMessage(@PathVariable Integer type){
        if(1==type){
            amqpTemplate.convertAndSend("myOrder","computer","电脑订单 "+new Date());
        }else{
            amqpTemplate.convertAndSend("myOrder","fruit","水果订单 "+new Date());

        }

    }

    /**
     * 接收电脑订单消息
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "computer",
            value = @Queue("computerOrder")
    ))
    public void saveComputerMessage(String message){
        log.info("接收到了订单消息{}"+message);
    }

    /**
     * 接收水果订单消息
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "fruit",
            value = @Queue("fruitOrder")
    ))
    public void saveFruitMessage(String message){
        log.info("接收到了订单消息{}"+message);
    }

    /**  
     * @methord: sendStreamMessage  测试springcloud stream
     * @author： likui
     * @great： 2018/10/29 13:04  
     * @param： []  
     * @return： void  
     * @throws: 
     */
    @GetMapping("/sendstramemessage")
    public void sendStreamMessage(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("123");
        streamClient.output().send(MessageBuilder.withPayload(orderDTO).build());
    }

}
