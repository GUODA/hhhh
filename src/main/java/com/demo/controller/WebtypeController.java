package com.demo.controller;

import com.demo.model.Webtype;
import com.demo.service.WebtypeService;
import com.demo.util.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by caicai on 2016/5/24.
 */
@Controller
@RequestMapping(value = "/admin")
public class WebtypeController {
    JsonMapper nonNullBinder = JsonMapper.nonEmptyMapper();
    @Autowired
    private WebtypeService webtypeService;
    @RequestMapping(value = "/selectWebtype")
    @ResponseBody
    public String findWebtytpeById(Integer id) throws Exception {
        Webtype webtype=webtypeService.selectById(id);
        return nonNullBinder.toJson(webtype);
    }
    @RequestMapping(value = "/selectWebs")
    @ResponseBody
    public String findWebsByTypeName(String name){
        Webtype webtype=webtypeService.selectByWebsByWebtypeName(name);
        return nonNullBinder.toJson(webtype);
    }

}
