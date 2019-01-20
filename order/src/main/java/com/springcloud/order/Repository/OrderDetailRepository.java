package com.springcloud.order.Repository;

import com.springcloud.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program:
 * @description:
 * @author: Song
 * @create: Created in 2019-01-20 09:52
 * @Modified by:
 **/
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

}
