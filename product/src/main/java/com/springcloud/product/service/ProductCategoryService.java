package com.springcloud.product.service;

import com.springcloud.product.dataobject.ProductCategory;

import java.util.List;

/**
 * @program:
 * @description:
 * @author: Song
 * @create: Created in 2019-01-19 09:37
 * @Modified by:
 **/
public interface ProductCategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);   //In是查询（categoryTypeList）里面的参数在不在数据库中

}
