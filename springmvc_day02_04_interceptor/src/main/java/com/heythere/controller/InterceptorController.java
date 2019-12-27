package com.heythere.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/interceptor")
public class InterceptorController {
    @RequestMapping(path = "/testInterceptor")
    public String testInterceptor() {
        System.out.println("Inside testInterceptor");
        return "success";
    }
}
