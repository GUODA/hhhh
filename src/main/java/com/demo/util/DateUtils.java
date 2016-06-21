package com.demo.util;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * ClassName: DateUtils
 * Description: 时间处理
 *
 * @author kang.wang03
 *         Date 16/1/25
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
    public static final String YYYY_MM_DD_HH_MM_SS ="yyyy-MM-dd HH:mm:ss";
    public static final String YYYYMMDDHHMMSS  = "yyyyMMddHHmmss";
    public final static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM", "yyyyMMddHHmmss"};

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String getDate(String pattern) {
        return getDate(pattern, new Date());
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String getDate(String pattern, Date date) {
        return DateFormatUtils.format(new Date(), pattern);
    }
}
