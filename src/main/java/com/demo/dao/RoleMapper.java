package com.demo.dao;

import com.demo.dao.base.BaseMapper;
import com.demo.model.Role;

public interface RoleMapper extends BaseMapper<Role>{
    Role getRoleByName(String name);
}