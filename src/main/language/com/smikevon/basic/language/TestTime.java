package com.smikevon.basic.language;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author 冯枭 E-mail:fengxiao@xiaomi.com
 * @since 创建时间: 14-11-26 下午8:26
 */
public class TestTime {

    public static void main(String[] args) throws InterruptedException, ParseException {
        System.out.println(TimeUnit.SECONDS.toMillis(1));
        System.out.println(TimeUnit.SECONDS.toNanos(1));

        System.out.println(TimeUnit.MILLISECONDS.toNanos(1));

        long start = System.nanoTime();
        Thread.sleep(1000);
        long end = System.nanoTime();

        System.out.println(end - start);

        long period = 1338655465;

        DateTime time = new DateTime(1230023);
        System.out.println(time.toDateTime());

        DateTime timestart = new DateTime();

        Interval interval = new Interval(time,timestart);

        Period p = interval.toPeriod();
        System.out.println(p.getDays()+"|"+p.getHours()+"|"+p.getMinutes());

        System.out.println(new Date().getTime());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        ;

        Period p2 = new Interval(sdf.parse("2014/06/23 09:10:10").getTime(),sdf.parse("2014/11/24 09:18:10").getTime()).toPeriod();



        System.out.println(p2.getDays()+"|"+p2.getMinutes());
    }
}
