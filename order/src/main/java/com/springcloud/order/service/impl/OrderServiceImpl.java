package com.springcloud.order.service.impl;

import com.springcloud.order.Repository.OrderDetailRepository;
import com.springcloud.order.Repository.OrderMasterRepository;
import com.springcloud.order.dataobject.OrderMaster;
import com.springcloud.order.dto.OrderDTO;
import com.springcloud.order.enums.OrderStatusEnum;
import com.springcloud.order.enums.PayStatusEnum;
import com.springcloud.order.service.OrderService;
import com.springcloud.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @program:
 * @description:
 * @author: Song
 * @create: Created in 2019-01-20 11:02
 * @Modified by:
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    OrderMasterRepository orderMasterRepository;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        //TODO 查询商品信息(调用商品服务)
        //TODO 计算总价
        //TODO 扣库存(调用商品服务)

        // 订单入库
        OrderMaster orderMaster = new OrderMaster();
//        orderMaster.setBuyerOpenid(orderDTO.getBuyerOpenid());
//        orderMaster.setBuyerName(orderDTO.getBuyerName());
//        orderMaster.setBuyerAddress(orderDTO.getBuyerAddress());
//        orderMaster.setBuyerPhone(orderDTO.getBuyerPhone());
        orderDTO.setOrderId(KeyUtil.genUniqueKey());
        BeanUtils.copyProperties(orderDTO,orderMaster);  //将orderDTO中的内容拷贝到orderMaster
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setCreateTime(new Date());
        orderMaster.setUpdateTime(new Date());

        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
