package com.example.bank.utils;

import java.util.Date;

public class DateUtil {
    public static Long BetweenDays(Date earlyDate,Date laterDate){
        Long betweenDays = (laterDate.getTime() - earlyDate.getTime()) / (1000L*3600L*24L);
        System.out.println(betweenDays);
        return betweenDays;
    }
}
