package com.springcloud.order.Repository;

import com.springcloud.order.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program:
 * @description:
 * @author: Song
 * @create: Created in 2019-01-20 09:53
 * @Modified by:
 **/
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
