package com.demo.exception;


import org.apache.shiro.authc.AuthenticationException;

/**
 * 验证码异常
 */
public class CaptchaException extends AuthenticationException {
    private static final long serialVersionUID = 1L;

    public CaptchaException() {
        super();
    }

    public CaptchaException(String message) {
        super(message);
    }
}
