package com.springcloud.product.service.impl;

import com.springcloud.product.Repository.ProductCategoryRepository;
import com.springcloud.product.dataobject.ProductCategory;
import com.springcloud.product.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program:
 * @description:  商品的类目
 * @author: Song
 * @create: Created in 2019-01-19 09:38
 * @Modified by:
 **/
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}
