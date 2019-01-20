package com.springcloud.order.Exception;

/**
 * @program:
 * @description:
 * @author: Song
 * @create: Created in 2019-01-20 19:57
 * @Modified by:
 **/
public class OrderException extends RuntimeException {
    private Integer code;

    public OrderException(int code, String message){
        super(message);
        this.code = code;

    }

}
