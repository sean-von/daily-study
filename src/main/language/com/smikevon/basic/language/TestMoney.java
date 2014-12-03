package com.smikevon.basic.language;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * @author 冯枭 E-mail:fengxiao@xiaomi.com
 * @since 创建时间: 14-12-2 下午9:07
 */
public class TestMoney {

    public static void main(String[] args){
        BigDecimal a = new BigDecimal("3.14");
        BigDecimal b = new BigDecimal("5.00");

        System.out.println(a.divide(b));
        System.out.println(a.divide(b,BigDecimal.ROUND_CEILING));
    }

    public BigDecimal getMoney(Double a){
        return new BigDecimal(Double.toString(a));
    }
}
