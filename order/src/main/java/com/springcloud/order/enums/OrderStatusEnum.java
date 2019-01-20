package com.springcloud.order.enums;

import lombok.Getter;

/**
 * @program:
 * @description:
 * @author: Song
 * @create: Created in 2019-01-20 10:21
 * @Modified by:
 **/
@Getter   //只生成get方法
public enum OrderStatusEnum {

    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "取消"),
    ;
    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
