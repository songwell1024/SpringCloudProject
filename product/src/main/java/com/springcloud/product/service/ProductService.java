package com.springcloud.product.service;

import com.springcloud.product.dataobject.ProductInfo;

import java.util.List;

/**
 * @program:
 * @description:
 * @author: Song
 * @create: Created in 2019-01-19 09:21
 * @Modified by:
 **/
public interface ProductService {
    List<ProductInfo> findUpAll();

}
