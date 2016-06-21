package com.demo.dao;

import com.demo.dao.base.BaseMapper;
import com.demo.model.Permission;

import java.util.Set;

public interface PermissionMapper extends BaseMapper<Permission>{
    Set<Permission> getAllPermissions();
    Permission getPermission(String resource, String operation,
                             String instance, boolean resourcePerm, boolean systemPerm);
}