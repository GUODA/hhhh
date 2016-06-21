package com.demo.service.impl;

import com.demo.dao.WebtypeMapper;
import com.demo.model.Webtype;
import com.demo.service.WebtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by caicai on 2016/5/24.
 */
@Service
public class WebtypeServiceImpl implements WebtypeService{
    @Autowired
    @Qualifier("webtypeMapper")
    private WebtypeMapper webtypeDAO;
    public Webtype selectById(Integer id) throws Exception {
        return webtypeDAO.selectByPrimaryKey(id);
    }
    public Webtype selectByWebsByWebtypeName(String name){
        return webtypeDAO.selectByWebsByWebtypeName(name);
    }
}
