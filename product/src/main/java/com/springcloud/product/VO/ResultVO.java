package com.springcloud.product.VO;

import lombok.Data;

/**
 * @program:
 * @description:  http请求返回的最外层对象
 * @author: Song
 * @create: Created in 2019-01-19 09:38
 * @Modified by:
 **/
@Data
public class ResultVO<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;
}
