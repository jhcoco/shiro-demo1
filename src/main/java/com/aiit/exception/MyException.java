package com.aiit.exception;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: jhzhong
 * @date: 2023/2/28 17:24
 * @desc:
 */
public class MyException implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ex.printStackTrace();
        ModelAndView mv = new ModelAndView();
        if (ex instanceof UnknownAccountException || ex instanceof IncorrectCredentialsException) {
            mv.setViewName("login");
        }
        return mv;
    }
}
