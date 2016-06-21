package com.demo.util;


import com.demo.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * ClassName: UserConstants
 * Description: 用户全局静态常量
 *
 * @author kang.wang03
 *         Date 16/2/4
 */
public class UserConstants {
    public static final String USER_UID = "user_uid";
    public static final boolean DEBUG = true;

    public static String getUserUid(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        return (String) httpSession.getAttribute(USER_UID);
    }

    /**
     * 客户端登录
     *
     * @param user
     * @param request
     */
    public static void login(User user, HttpServletRequest request) {
        request.getSession().setAttribute(USER_UID, user.getId() + "");
    }

    /**
     * 客户端登出
     *
     * @param request
     */
    public static void logout(HttpServletRequest request) {
        try {
            request.logout();
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }
}
