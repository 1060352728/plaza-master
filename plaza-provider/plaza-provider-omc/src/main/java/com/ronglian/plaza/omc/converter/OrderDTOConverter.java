package com.ronglian.plaza.omc.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ronglian.plaza.omc.dto.OrderDTO;
import com.ronglian.plaza.common.entity.omc.OrderDetail;
import com.ronglian.plaza.omc.enums.ResultEnum;
import com.ronglian.plaza.omc.form.OrderForm;
import com.ronglian.plaza.omc.exception.OrderException;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by likui
 * 2018-10-9 21:46
 */
@Slf4j
public class OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception e) {
            log.error("【json转换】错误, string={}", orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
