package com.demo.dao;

import com.demo.dao.base.BaseMapper;
import com.demo.model.User;
import com.demo.model.UserMessage;

import java.util.List;
import java.util.Set;

public interface UserMapper extends BaseMapper<User> {
    List<User> selectList();
    User getUserByAccount(String account);
    Set<String> getRoleName();
    UserMessage getUserMessage();
    void insertRoleUser(Integer user_id,Integer role_id);
}