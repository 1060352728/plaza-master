package com.ronglian.plaza.util.common;

import java.util.Random;

/**
 * @author likui
 * @Classname: OmcOrderController
 * @Description: 主键生产工具
 * @create 2018-09-26 16:55
 **/
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式: 时间+随机数
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
