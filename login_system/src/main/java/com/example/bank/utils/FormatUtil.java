package com.example.bank.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatUtil {
    public static String DateFormat(Date date){
        SimpleDateFormat sfm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String res = sfm.format(date);
        return res;
    }
}
