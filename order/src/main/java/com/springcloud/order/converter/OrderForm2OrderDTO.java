package com.springcloud.order.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.springcloud.order.Exception.OrderException;
import com.springcloud.order.dataobject.OrderDetail;
import com.springcloud.order.dto.OrderDTO;
import com.springcloud.order.enums.ResultEnum;
import com.springcloud.order.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: Song
 * @create: Created in 2019-01-20 20:09
 * @Modified by:
 **/
@Slf4j
public class OrderForm2OrderDTO {

    public static OrderDTO convert(OrderForm orderForm){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            Gson gson = new Gson();
            //反序列化
            gson.fromJson(orderForm.getItems(),new TypeToken<List<OrderDetail>>(){}.getType());
        }catch (Exception e){
            log.error("json转换错误， string={}", orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
                     ResultEnum.PARAM_ERROR.getMessage());
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }

}
