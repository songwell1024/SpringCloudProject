package com.springcloud.product.Repository;

import com.springcloud.product.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program:
 * @description: ProductInfo是你要查询的数据的类型,String是你数据表的主键的类型
 * @author: Song
 * @create: Created in 2019-01-18 21:34
 * @Modified by:
 **/
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);

}
