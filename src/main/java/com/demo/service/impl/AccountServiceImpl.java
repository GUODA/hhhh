package com.demo.service.impl;

import com.demo.dao.AccountMapper;
import com.demo.model.Account;
import com.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by caicai on 2016/5/31.
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    @Qualifier("accountMapper")
    private AccountMapper accountDAO;

    public Account getById(Integer id) {
        return accountDAO.selectByPrimaryKey(id);
    }
}
