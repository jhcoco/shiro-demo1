package com.aiit.dao;

import com.aiit.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    User queryUserByLoginName(@Param("principal") String principal);

    List<String> queryRolesByLoginName(@Param("principal") String principal);

    List<String> queryPermissionByLoginName(@Param("principal") String principal);

    Integer insertUser(User user);
}
