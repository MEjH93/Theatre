package com.theatre.domain;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateTest {

    public static void main(String[] args) {
        Date myDate = new Date(0);
        System.out.println(myDate);
        System.out.println(new SimpleDateFormat("MM-dd-yyyy").format(myDate));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(myDate));
        System.out.println(myDate);
    }

}
