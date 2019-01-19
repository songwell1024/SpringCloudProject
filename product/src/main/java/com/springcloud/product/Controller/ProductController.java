package com.springcloud.product.Controller;

import com.springcloud.product.Util.ResultVOUtil;
import com.springcloud.product.VO.ProductInfoVO;
import com.springcloud.product.VO.ProductVO;
import com.springcloud.product.VO.ResultVO;
import com.springcloud.product.dataobject.ProductCategory;
import com.springcloud.product.dataobject.ProductInfo;
import com.springcloud.product.service.ProductCategoryService;
import com.springcloud.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program:
 * @description:
 * @author: Song
 * @create: Created in 2019-01-17 09:12
 * @Modified by:
 **/
@RestController
@RequestMapping("/product")
public class ProductController {
    /**
     * 1. 查询所有在架的商品
     * 2. 获取类目type列表
     * 3. 查询类目
     * 4. 构造数据
     */

    @Autowired
    ProductService productService;
    @Autowired
    ProductCategoryService productCategoryService;

//    @RequestMapping(path = "/list", method = RequestMethod.GET)
    @GetMapping("/list")
    public ResultVO<ProductVO> list(){
//        * 1. 查询所有在架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();
//         * 2. 获取类目type列表
        List<Integer> categoryTypeList = productInfoList.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
//         * 3. 查询类目
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);
//          * 4. 构造数据
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList){
                ProductInfoVO productInfoVO = new ProductInfoVO();
                if(productInfo.getCategoryType().equals(productCategory)){
                    productInfoVO.setProductId(productInfo.getProductId());
                    productInfoVO.setProductName(productInfo.getProductName());
                    productInfoVO.setProductPrice(productInfo.getProductPrice());
                    productInfoVO.setProductIcon(productInfo.getProductIcon());
                    productInfoVO.setProductDescription(productInfo.getProductDescription());
                    productInfoVOList.add(productInfoVO);
                }

            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }



}
