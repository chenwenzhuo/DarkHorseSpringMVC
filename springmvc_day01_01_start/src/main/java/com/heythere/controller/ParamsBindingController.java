package com.heythere.controller;

import com.heythere.domain.Account;
import com.heythere.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("paramsBinding")
public class ParamsBindingController {
    @RequestMapping("testParamsBinding")
    public String testParamsBinding(String username, int age) {
        System.out.println("参数绑定");
        System.out.println("用户名：" + username);
        System.out.println("年龄：" + age);

        return "success";
    }

    @RequestMapping("saveAccount")
    public String saveAccount_beanBinding(Account account) {
        System.out.println("参数绑定——JavaBean");
        System.out.println(account);

        return "success";
    }

    @RequestMapping("saveProduct")
    public String saveProduct(Product product) {
        System.out.println("自定义类型转换器");
        System.out.println(product);

        return "success";
    }
}
