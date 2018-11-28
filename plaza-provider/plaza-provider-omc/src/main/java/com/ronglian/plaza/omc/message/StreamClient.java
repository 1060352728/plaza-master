package com.ronglian.plaza.omc.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author likui
 * @Classname: StreamClient
 * @Description: 消息接口
 * @create 2018-10-29 12:55
 **/
public interface StreamClient {

    /**
     * 这一块有个坑，tongyig通道名称不能相同，书上的有错
     */
    String INPUT = "stream_input";

    String OUTPUT = "stream_output";

    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Output(StreamClient.OUTPUT)
    MessageChannel output();

}
