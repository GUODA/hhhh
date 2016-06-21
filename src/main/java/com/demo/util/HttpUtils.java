package com.demo.util;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName: HttpUtils
 * Description: 网络工具类
 *
 * @author kang.wang03
 *         Date 16/1/24
 */
public class HttpUtils {
    public static String getRemoteIp(HttpServletRequest request){
        return request.getRemoteAddr();
    }
}
