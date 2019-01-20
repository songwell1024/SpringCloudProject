package com.springcloud.order.service;

import com.springcloud.order.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: 商品订单参数校验
 * @description:
 * @author: Song
 * @create: Created in 2019-01-20 10:54
 * @Modified by:
 **/
public interface OrderService {
    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);


}
