package com.springcloud.order.Repository;

import com.springcloud.order.OrderApplicationTests;
import com.springcloud.order.dataobject.OrderDetail;
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
 * @create: Created in 2019-01-20 10:02
 * @Modified by:
 **/
@Component
public class OrderDetailRepositoryTest extends OrderApplicationTests {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void testSave() throws Exception {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("12367");
        orderDetail.setOrderId("123456");
        orderDetail.setProductIcon("http://xxx.com");
        orderDetail.setProductId("157875196366160022");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(0.01));
        orderDetail.setProductQuantity(2);
        orderDetail.setCreateTime(new Date());
        orderDetail.setUpdateTime(new Date());

        OrderDetail result = orderDetailRepository.save(orderDetail);
        Assert.assertTrue(result != null);
    }

}