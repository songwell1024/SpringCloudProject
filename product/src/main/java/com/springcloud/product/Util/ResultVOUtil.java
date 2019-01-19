package com.springcloud.product.Util;

import com.springcloud.product.VO.ResultVO;

/**
 * @program:
 * @description:
 * @author: Song
 * @create: Created in 2019-01-19 21:42
 * @Modified by:
 **/
public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

}
