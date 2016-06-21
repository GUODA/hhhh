package com.demo.service;

import com.demo.model.Webtype;

/**
 * Created by caicai on 2016/5/24.
 */
public interface WebtypeService {
    public Webtype selectById(Integer id) throws Exception;
    public Webtype selectByWebsByWebtypeName(String name);
}
