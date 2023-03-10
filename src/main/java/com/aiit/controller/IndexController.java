package com.aiit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: jhzhong
 * @date: 2023/3/6 9:11
 * @desc:
 */
@Controller
public class IndexController {

    //    @RequestMapping(value = {"/","/index"},method = RequestMethod.GET)
    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping(value = "/permission")
    public String permissionPage() {
        return "permission";
    }

    @GetMapping(value = "/toLogin")
    public String toLoginPage() {
        return "login";
    }

    @GetMapping(value = "/toRegister")
    public String toRegisterPage() {
        return "register";
    }

    @GetMapping(value = "/getUsers")
    public String userList() {
        // logic
        return "user_list";
    }
}
