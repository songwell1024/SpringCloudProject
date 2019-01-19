package com.springcloud.product.Enums;

import lombok.Getter;

/**
 * @program:
 * @description:  商品的上下架状态
 * @author: Song
 * @create: Created in 2019-01-19 09:26
 * @Modified by:
 **/
@Getter
public enum ProductStatusEnums {
    UP(0, "在架"),
    DOWN(1, "下架"),
    ;

    private Integer code;
    private String message;

    ProductStatusEnums(Integer code, String message){
        this.code = code;
        this.message = message;
    }

}
