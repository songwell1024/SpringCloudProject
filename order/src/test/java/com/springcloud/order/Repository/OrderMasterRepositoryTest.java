package com.springcloud.order.Repository;

import com.springcloud.order.OrderApplicationTests;
import com.springcloud.order.dataobject.OrderMaster;
import com.springcloud.order.enums.OrderStatusEnum;
import com.springcloud.order.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @program:
 * @description:
 * @author: Song
 * @create: Created in 2019-01-20 09:57
 * @Modified by:
 **/
@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests {

    @Autowired
    OrderMasterRepository orderMasterRepository;

    @Test
    public void testSave() throws Exception{
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("1886131241241");
        orderMaster.setBuyerAddress("慕课网总部");
        orderMaster.setBuyerOpenid("1101110");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setCreateTime(new Date());
        orderMaster.setUpdateTime(new Date());

        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertTrue(result != null);

    }

}