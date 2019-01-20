package com.springcloud.order.enums;

import lombok.Getter;

/**
 * @program:
 * @description:
 * @author: Song
 * @create: Created in 2019-01-20 10:21
 * @Modified by:
 **/
@Getter
public enum PayStatusEnum {

    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
            ;
    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
