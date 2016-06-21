package com.demo.auth;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 用户名,密码,验证码
 */
public class UsernamePasswordCaptchaToken extends UsernamePasswordToken {

    private String captcha;

    public UsernamePasswordCaptchaToken() {
        super();
    }

    public UsernamePasswordCaptchaToken(String username, char[] password,
                                        boolean rememberMe, String host, String captcha) {
        super(username, password, rememberMe, host);
        this.captcha = captcha;
    }

    public UsernamePasswordCaptchaToken(String username, String password,
                                        boolean rememberMe, String host, String captcha) {
        this(username, password != null ? password.toCharArray() : null,
            rememberMe, host, captcha);
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
