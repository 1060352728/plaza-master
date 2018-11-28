package com.ronglian.plaza.omc.message;

import com.ronglian.plaza.omc.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @author likui
 * @Classname: StreamReceiver
 * @Description: 消息接收
 * @create 2018-10-29 12:55
 **/
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

    @StreamListener(StreamClient.OUTPUT)
    @SendTo(StreamClient.INPUT) //通知消息
    public OrderDTO receiveMessage(OrderDTO message){
        log.info("接收到消息{}"+message);
        return message;
    }

    @StreamListener(StreamClient.INPUT)
    public void receiveMessageBack(OrderDTO message){
        log.info("接收到返回消息{}"+message);
    }
}
