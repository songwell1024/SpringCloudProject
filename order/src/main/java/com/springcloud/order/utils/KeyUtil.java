package com.springcloud.order.utils;

import java.util.Random;

/**
 * @program:
 * @description:
 * @author: Song
 * @create: Created in 2019-01-20 18:19
 * @Modified by:
 **/
public class KeyUtil {
    /**
     * 生成唯一的主键
     * 格式：时间 + 随机数
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        int number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }

}
