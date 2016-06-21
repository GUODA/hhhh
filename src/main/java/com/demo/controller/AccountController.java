package com.demo.controller;

import com.demo.model.Account;
import com.demo.service.AccountService;
import com.demo.util.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by caicai on 2016/5/31.
 */
@Controller
@RequestMapping("/admin/account")
public class AccountController {
    JsonMapper nonNullBinder = JsonMapper.nonEmptyMapper();
    @Autowired
    private AccountService accountService;
    @RequestMapping(value = "/find",method = RequestMethod.GET)
    @ResponseBody
    public String getAccountById(Integer id){
        Account account= accountService.getById(id);
        return nonNullBinder.toJson(account);
    }
}
