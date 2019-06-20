package com.wang.common.util;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

/**
 * @author: whb
 * @date: 2019/6/20 15:29
 * @description: 工具类
 */
public class CommonUtils {

    public synchronized static String getNextCode() {
        return UUID.randomUUID().toString();
    }


    public synchronized static BigDecimal getFee() {
        Random rand = new Random();
        double fee = rand.nextDouble();
        return new BigDecimal(fee);
    }

}
