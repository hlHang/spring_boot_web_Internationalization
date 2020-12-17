package com.hlh.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping(value = "/user/login")
    // @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public String login(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            Map<String,Object> map, HttpSession session) {
        if (!StringUtils.isEmpty(email) && "123456".equals(password)){
            session.setAttribute("loginEmail",email);
            return "redirect:/main.html";
        }else{
            // 登陆失败
            map.put("msg","用户名密码错误");
            return "login";
        }

    }

}
