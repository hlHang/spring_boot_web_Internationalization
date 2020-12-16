package com.hlh.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class helloController {



    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "hello World";
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello","你好");
        map.put("users", Arrays.asList("张三","李四"));
        return "success";
    }

}
