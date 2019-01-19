package com.springcloud.product.service;

import com.springcloud.product.ProductApplication;
import com.springcloud.product.ProductApplicationTests;
import com.springcloud.product.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


/**
 * @program:
 * @description:
 * @author: Song
 * @create: Created in 2019-01-19 09:40
 * @Modified by:
 **/
@Component
public class ProductCategoryServiceTest extends ProductApplicationTests {

    @Autowired
    ProductCategoryService productCategoryService;

    @Test
    public void findByCategoryTypeIn() throws Exception{

        List<ProductCategory> list = productCategoryService.findByCategoryTypeIn(Arrays.asList(11,12));
        Assert.assertTrue(list.size() > 0);
    }

}