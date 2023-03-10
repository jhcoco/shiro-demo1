package com.aiit.service.impl;

import com.aiit.dao.UserDao;
import com.aiit.pojo.User;
import com.aiit.service.IUserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * @author: jhzhong
 * @date: 2023/3/6 15:46
 * @desc:
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    public User queryUserByLoginName(String loginName) {
        return userDao.queryUserByLoginName(loginName);
    }

    public Set<String> queryRolesByLoginName(String principal) {
        List<String> roles = userDao.queryRolesByLoginName(principal);
        return new HashSet<String>(roles);
    }


    public Set<String> queryPermissionByLoginName(String principal) {
        List<String> permissions = userDao.queryPermissionByLoginName(principal);
        return new HashSet<String>(permissions);
    }

    public Integer insertUser(User user) {
        user.setSalt(UUID.randomUUID().toString());
        System.out.println("user.getSalt() = " + user.getSalt());
        System.out.println("user.getSaltLength = " + user.getSalt().length());
        String pwBase64 = new Sha256Hash(user.getPassword(), user.getSalt(), 1024).toBase64();
        user.setPassword(pwBase64);
        return userDao.insertUser(user);
    }
}
