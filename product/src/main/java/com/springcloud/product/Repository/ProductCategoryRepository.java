package com.springcloud.product.Repository;

import com.springcloud.product.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program:
 * @description:
 * @author: Song
 * @create: Created in 2019-01-18 21:56
 * @Modified by:
 **/
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);   //In是查询（categoryTypeList）里面的参数在不在数据库中

}
