package com.springcloud.product.service.impl;

import com.springcloud.product.Enums.ProductStatusEnums;
import com.springcloud.product.Repository.ProductInfoRepository;
import com.springcloud.product.dataobject.ProductInfo;
import com.springcloud.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program:  查询商品的上下架状态
 * @description:
 * @author: Song
 * @create: Created in 2019-01-19 09:23
 * @Modified by:
 **/
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnums.UP.getCode());
    }
}
