package com.aiit.controller;

import com.aiit.pojo.User;
import com.aiit.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: jhzhong
 * @date: 2023/3/6 9:40
 * @desc:
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 登录逻辑
     */
    @PostMapping(value = "/login")
    public String login(User user, String isRemembered) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginName(), user.getPassword());
        token.setRememberMe(null != isRemembered);
        subject.login(token);
        Session session = subject.getSession();
        User currentUser = userService.queryUserByLoginName(token.getUsername());
        session.setAttribute("username", currentUser.getUsername());
        return "redirect:/getUsers";
    }

    @PostMapping(value = "/register")
    public String register(User user) {
        Integer rows = userService.insertUser(user);
        return rows > 0 ? "login" : "register";
    }

    // 退出登录
    @GetMapping(value = "/logout")
    public void logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        Session session = subject.getSession();
        session.stop();
    }

}
