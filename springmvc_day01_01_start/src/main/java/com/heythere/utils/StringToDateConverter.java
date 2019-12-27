package com.heythere.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date targetDate;
        try {
            targetDate = dateFormat.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("转换过程出错！");
        }
        return targetDate;
    }
}
