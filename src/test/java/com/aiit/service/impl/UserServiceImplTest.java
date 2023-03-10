package com.aiit.service.impl;

import com.aiit.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collections;
import java.util.Set;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    @Test
    public void queryUserByLoginName() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-application.xml");
        UserServiceImpl userService = applicationContext.getBean(UserServiceImpl.class);
        User user = userService.queryUserByLoginName("jhzhong");
        System.out.println(user.getLoginName());
    }

    @Test
    public void queryRolesByLoginName() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-application.xml");
        UserServiceImpl userService = applicationContext.getBean(UserServiceImpl.class);
        Set<String> roles = userService.queryRolesByLoginName("jhzhong");
        System.out.println(roles.size());
        System.out.println(roles);
    }

    @Test
    public void queryPermissionByLoginName() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-application.xml");
        UserServiceImpl userService = applicationContext.getBean(UserServiceImpl.class);
        Set<String> permissions = userService.queryPermissionByLoginName("jhzhong");
        System.out.println(permissions.size());
        System.out.println(permissions);
    }
}