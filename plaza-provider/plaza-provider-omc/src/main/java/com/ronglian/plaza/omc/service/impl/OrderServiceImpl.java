package com.ronglian.plaza.omc.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.ronglian.plaza.common.entity.omc.OrderDetail;
import com.ronglian.plaza.common.entity.omc.OrderMaster;
import com.ronglian.plaza.common.entity.psc.ProductInfoOutput;
import com.ronglian.plaza.omc.enums.ResultEnum;
import com.ronglian.plaza.omc.exception.OrderException;
import com.ronglian.plaza.util.common.KeyUtil;
import com.ronglian.plaza.omc.dto.OrderDTO;
import com.ronglian.plaza.omc.enums.OrderStatusEnum;
import com.ronglian.plaza.omc.enums.PayStatusEnum;
import com.ronglian.plaza.omc.mapper.OrderDetailMapper;
import com.ronglian.plaza.omc.mapper.OrderMasterMapper;
import com.ronglian.plaza.omc.service.OrderService;
import com.ronglian.plaza.psc.client.ProductFeignApi;
import com.ronglian.plaza.psc.common.DecreaseStockInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author likui
 * @Classname: OrderDetailServiceImpl
 * @Description: 订单详情实现类
 * @create 2018-10-09 13:01
 **/
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDetailMapper orderDetailMapper;

    @Autowired
    OrderMasterMapper orderMasterMapper;

    @Autowired
    ProductFeignApi productFeignApi;


    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    @TxTransaction(isStart = true)//开启分布式事物，演示lcn分布式事物
    @Transactional
    public OrderDTO greatOreder(OrderDTO orderDTO) {
        String orderId = KeyUtil.genUniqueKey();
        //1:根据前台传过来的productId查询商品信息(调用商品服务)
        List<String> productIdList = orderDTO.getOrderDetailList().stream()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        //2:查询订单中的所有商品
        List<ProductInfoOutput> productInfoList = productFeignApi.listForOrder(productIdList);
        //3:计算总价
        BigDecimal orderAmout = new BigDecimal(BigInteger.ZERO);
        for (OrderDetail orderDetail: orderDTO.getOrderDetailList()) {
            for (ProductInfoOutput productInfo: productInfoList) {
                if (productInfo.getProductId().equals(orderDetail.getProductId())) {
                    //单价*数量
                    orderAmout = productInfo.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmout);
                    BeanUtils.copyProperties(productInfo, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.genUniqueKey());
                    //订单详情入库
                    orderDetailMapper.saveOrderDetail(orderDetail);
                }
            }
        }
        //4:扣库存(调用商品服务)
        List<DecreaseStockInput> decreaseStockInputList = orderDTO.getOrderDetailList().stream()
                .map(e -> new DecreaseStockInput(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productFeignApi.decreaseStock(decreaseStockInputList);

        //5:订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(orderAmout);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterMapper.saveOrderMaster(orderMaster);
        //int i = 1/0;
        //log.info("创建订单故意制造异常，查看事物是否回滚");
        return orderDTO;
    }

    /**
     * 完结订单操作
     * @param orderId
     * @return
     */
    @Transactional
    public OrderDTO finishOrder(String orderId) {
        //1：先查询订单
        OrderMaster orderMaster = orderMasterMapper.findById(orderId);
        //2：判断订单的状态是否满足
        if(orderMaster == null){
            //3:订单不存在
            throw new OrderException(ResultEnum.ORDER_NOT_EXIST);
        }
        if(orderMaster.getOrderStatus() != OrderStatusEnum.NEW.getCode()){
            //4:订单状态错误
            throw new OrderException(ResultEnum.ORDER_STATUS_ERROR);
        }

        //5：修改订单的状态
        orderMasterMapper.finish(orderId,OrderStatusEnum.FINISHED.getCode());
        orderMaster.setOrderStatus(OrderStatusEnum.FINISHED.getCode());

        //6：根据orderid查询订单详情
        List<OrderDetail> orderDetailList = orderDetailMapper.findOrderDetailsByOrderId(orderId);
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }

    /**
     * 查询所有的订单
     * @return
     */
    @Override
    public List<OrderDTO> list() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
        //1:获取所有的order
        List<OrderMaster> orderMasterList = orderMasterMapper.list();
        //2:获取所有的orderid组成集合
        List<String> orderIds = orderMasterList.stream().map(OrderMaster::getOrderId).collect(Collectors.toList());
        //3:根据orderids查询所有的orderdetais
        List<OrderDetail> orderDetailList = orderDetailMapper.findByOrderIdIn(orderIds);
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (OrderMaster orderMaster : orderMasterList) {
            OrderDTO orderDTO = new OrderDTO();
            List<OrderDetail> orderDetails = new ArrayList<>();
            for (OrderDetail orderDetail : orderDetailList) {
                if(orderDetail.getOrderId().equals(orderMaster.getOrderId())){
                    orderDetails.add(orderDetail);
                }
            }
            BeanUtils.copyProperties(orderMaster,orderDTO);
            orderDTO.setOrderDetailList(orderDetails);
            orderDTOList.add(orderDTO);
        }
        return orderDTOList;
    }

    /**
     * 根据orderId查询order
     * @param orderId
     * @return
     */
    public OrderDTO findByOrderId(String orderId){
        //1：先查询订单
        OrderMaster orderMaster = orderMasterMapper.findById(orderId);
        //2：根据orderid查询订单详情
        List<OrderDetail> orderDetailList = orderDetailMapper.findOrderDetailsByOrderId(orderId);
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }

}
