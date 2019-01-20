package com.springcloud.order.enums;

import lombok.Getter;

/**
 * @program:
 * @description:
 * @author: Song
 * @create: Created in 2019-01-20 20:03
 * @Modified by:
 **/
@Getter
public enum ResultEnum {
    PARAM_ERROR(1,"参数错误"),
    ;

    private int code;
    private String message;
    ResultEnum(int code, String message){
        this.message = message;
        this.code = code;
    }
}
