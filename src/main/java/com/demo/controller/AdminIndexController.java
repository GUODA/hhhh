package com.demo.controller;

import com.demo.auth.ShiroDbRealm;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by caicai on 2016/6/3.
 */
@Controller
@RequestMapping("/admin")
public class AdminIndexController {
    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        String account = ((ShiroDbRealm.ShiroUser) SecurityUtils.getSubject()
                .getPrincipal()).getUsername();
        try {
            modelAndView.addObject("userName", account);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
}
