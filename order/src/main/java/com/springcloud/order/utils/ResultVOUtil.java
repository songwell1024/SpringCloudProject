package com.springcloud.order.utils;

import com.springcloud.order.VO.ResultVo;

/**
 * @program:
 * @description:
 * @author: Song
 * @create: Created in 2019-01-20 20:48
 * @Modified by:
 **/
public class ResultVOUtil {

    public static ResultVo success(Object object){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        resultVo.setData(object);
        return resultVo;
    }

}
