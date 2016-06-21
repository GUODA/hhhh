package com.demo.auth;


import com.demo.exception.CaptchaException;
import com.demo.model.User;
import com.demo.service.UserService;
import com.google.code.kaptcha.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.io.Serializable;


public class ShiroDbRealm extends JdbcRealm {
    private static final Logger logger = LoggerFactory
            .getLogger(ShiroDbRealm.class);

    @Autowired
    private UserService userService;

    /**
     * 异常抛出 未被捕获 java运行时环境终止，程序退出
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authToken) throws AuthenticationException {
        UsernamePasswordCaptchaToken token = (UsernamePasswordCaptchaToken) authToken;
        logger.info("认证开始执行,用户:{}", token.getUsername());
        String username = token.getUsername();
        String captcha = token.getCaptcha();
        String exitCode = (String) SecurityUtils.getSubject().getSession()
                .getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (StringUtils.isBlank(captcha)
                || !captcha.equalsIgnoreCase(exitCode)) {
            throw new CaptchaException("验证码错误");
        }

        User user = userService.findByAccount(username);
        SimpleAuthenticationInfo info;
        if (user != null) {
            info= new SimpleAuthenticationInfo(
                    new ShiroUser(user.getAccount()), user.getPassword(), getName());
        } else {
            throw new UnknownAccountException(
                    "No account found for user [" + username + "]");
        }
        return  info;
    }
    @PostConstruct
    public void initTokenClass() {
        // 设置认证token的实现类
        setAuthenticationTokenClass(UsernamePasswordCaptchaToken.class);
    }

    @PostConstruct
    public void initCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher("SHA-1");
        setCredentialsMatcher(matcher);
    }

    /**
     * 更新用户授权信息缓存.
     */
    public void clearCachedAuthorizationInfo(String principal) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
        clearCachedAuthorizationInfo(principals);
    }

    /**
     * 清除所有用户授权信息缓存.
     */
    public void clearAllCachedAuthorizationInfo() {
        Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
        if (cache != null) {
            for (Object key : cache.keys()) {
                cache.remove(key);
            }
        }
    }
    public static class ShiroUser implements Serializable {
        private String username;

        public ShiroUser(String username) {
            this.username = username;
        }


        public String getUsername() {
            return username;
        }

        @Override
        public String toString() {
            return username;
        }
    }

}