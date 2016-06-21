package com.demo.controller;

import com.demo.auth.ShiroDbRealm;
import com.demo.auth.UsernamePasswordCaptchaToken;
import com.demo.dao.UserMapper;
import com.demo.dao.UserMessageMapper;
import com.demo.exception.CaptchaException;
import com.demo.model.User;
import com.demo.model.UserMessage;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by caicai on 2016/6/2.
 */
@Controller
@RequestMapping
public class AdminLoginController {
    private Logger logger = LoggerFactory.getLogger(AdminLoginController.class);

    @RequestMapping(value = "/admin/login", method = RequestMethod.GET)
    public String getLoginForm() {
        return "/login";
    }

    @Autowired
    @Qualifier("userMapper")
    private UserMapper userDAO;
    @Autowired
    @Qualifier("userMessageMapper")
    private UserMessageMapper userMessageDAO;

    @RequestMapping(value = "/admin/login", method = RequestMethod.POST,
            produces = "text/plain;charset=utf-8")
    public String login(@RequestParam String username,
                        @RequestParam String password,@RequestParam String verification,
                        @RequestParam(required = false) boolean remember,
                        HttpServletRequest request, Model model) {
        logger.info("admin login begin;");
        String realIP = request.getHeader("x-forwarded-for");
        String ip = request.getRemoteAddr();
        String host = realIP;
        if (realIP == null || realIP.length() == 0) {
            host = ip;
        }
        UsernamePasswordCaptchaToken token=new UsernamePasswordCaptchaToken(username,password,remember,host,verification);
        Subject subject=SecurityUtils.getSubject();
      try{
            subject.login(token);
          ShiroDbRealm.ShiroUser shiroUser = (ShiroDbRealm.ShiroUser) subject
                  .getPrincipal();
          HttpSession session = request.getSession(true);
          session.setAttribute("shiroUser", shiroUser);

            /* 管理员登录后记录登录信息 bijing 20160215 */
          User user = userDAO.getUserByAccount(shiroUser.getUsername());
          UserMessage userMessage=userDAO.getUserMessage();
          if (userMessage != null) {
              userMessage.setLoginip(host);
              userMessage.setLogintime(new Date());
              userMessage.setUserId(user.getId());
              userMessageDAO.updateByPrimaryKeySelective(userMessage);
          }else {
              UserMessage userMes=new UserMessage();
              userMes.setLoginip(host);
              userMes.setLogintime(new Date());
              userMes.setUserId(user.getId());
              userMessageDAO.insertSelective(userMes);
          }
          if(subject.isAuthenticated()) {
              return "redirect:/admin/index";
          }else {
              return "login";
          }
        } catch (CaptchaException ce) {
            logger.info("验证码错误");
            model.addAttribute("errorMsg", "验证码错误");
        } catch (UnknownAccountException uae) {
            logger.info("用户不存在");
            model.addAttribute("errorMsg", "用户不存在");
        } catch (IncorrectCredentialsException ice) {
            logger.info("用户名或密码错误");
            model.addAttribute("errorMsg", "用户名或密码错误");
        } catch (LockedAccountException lae) {
            logger.info("该用户被锁定");
            model.addAttribute("errorMsg", "用户被锁定");
        } catch (AuthenticationException ae) {
            logger.info("用户认证失败");
            model.addAttribute("errorMsg", "用户认证失败");
        }
        request.setAttribute("username", username);
        /* 后台登陆出错后的返回页面，返回登录页面 */
        return "login";

    }
}
