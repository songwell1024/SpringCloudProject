package com.springcloud.order.VO;

import lombok.Data;

/**
 * @program:
 * @description:
 * @author: Song
 * @create: Created in 2019-01-20 20:47
 * @Modified by:
 **/
@Data
public class ResultVo<T> {

    private Integer code;
    private String msg;
    private T data;


}
