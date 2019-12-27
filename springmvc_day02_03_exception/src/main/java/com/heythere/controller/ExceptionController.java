package com.heythere.controller;

import com.heythere.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "exception")
public class ExceptionController {
    @RequestMapping(path = "testException")
    public String testException() throws SysException {
        System.out.println("Inside testException");

        try {
            //模拟异常
            int n = 10 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("Divided by zero!");
        }
        return "success";
    }
}
