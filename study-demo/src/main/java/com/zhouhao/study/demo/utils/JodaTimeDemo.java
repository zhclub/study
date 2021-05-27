package com.zhouhao.study.demo.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;

/**
 * joda-time：时间操作工具类
 */
public class JodaTimeDemo {

    /**
     * DateTime基础用法
     */
    public void basic() {
        // 当前时间
        DateTime dateTime1 = DateTime.now();
        // 将时间按照具体的格式转换为DateTime
        DateTime dateTime2 = DateTime.parse("2021-05-26 17:23:56", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
        // 设定具体的年、月、日、时、分、秒、毫秒和时区
        DateTime dateTime3 = new DateTime(2020, 8, 12, 8, 52, 0);

        DateTime dateTime = new DateTime();
        // 增加1天
        DateTime dateTime6 = dateTime.plusDays(1);
        // 减少1小时
        DateTime dateTime7 = dateTime.plusHours(-1);

        // 今天是周几
        int dayOfWeek = dateTime.getDayOfWeek();
        // 今天是当月的第几天
        int dayOfMonth = dateTime.getDayOfMonth();
        // 今天是今年的第几天
        int dayOfYear = dateTime.getDayOfYear();
        // 现在是那一年
        int year = dateTime.getYear();
        // 现在是几月
        int monthOfYear = dateTime.getMonthOfYear();
    }

    /**
     * DateTime的转换
     */
    private void convertor() {
        // jdk的Date对象转DateTime
        DateTime dateTime1 = new DateTime(new Date());
        // 时间戳转DateTime
        DateTime dateTime2 = new DateTime(System.currentTimeMillis());
        // DateTime转jdk的Date对象
        Date date = DateTime.now().toDate();
    }

    public static void main(String[] args) {
        JodaTimeDemo demo = new JodaTimeDemo();
        demo.basic();
    }

    private void print(DateTime dateTime) {
        System.out.println(dateTime.toString("yyyy-MM-dd HH:mm:ss"));
    }
}
