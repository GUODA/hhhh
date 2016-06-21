package com.demo.dao;

import com.demo.dao.base.BaseMapper;
import com.demo.model.Webtype;

public interface WebtypeMapper extends BaseMapper<Webtype> {

    Webtype selectByWebsByWebtypeName(String name);
}