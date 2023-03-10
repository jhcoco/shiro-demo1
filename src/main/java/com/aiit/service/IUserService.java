package com.aiit.service;

import com.aiit.pojo.User;

import java.util.Set;

public interface IUserService {
    User queryUserByLoginName(String loginName);

    Set<String> queryRolesByLoginName(String principal);

    Set<String> queryPermissionByLoginName(String principal);

    Integer insertUser(User user);
}
