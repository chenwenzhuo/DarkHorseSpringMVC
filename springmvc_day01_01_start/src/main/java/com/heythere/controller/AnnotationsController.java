package com.heythere.controller;

import com.heythere.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("annotations")
public class AnnotationsController {

    @RequestMapping("requestParam")
    public String testRequestParam(@RequestParam(name = "msg") String message) {
        System.out.println(message);
        return "success";
    }

    @RequestMapping(path = "requestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println(body);
        return "success";
    }
    /*@RequestMapping("requestBody")
    public String testRequestBody(String username, int age) {
        System.out.println(username);
        System.out.println(age);
        return "success";
    }*/

    @RequestMapping("pathVariable/{id}")
    public String testPathVariable(@PathVariable(name = "id") int idVal) {
        System.out.println("id = " + idVal);
        return "success";
    }

    @RequestMapping("requestHeader")
    public String testRequestHeader(@RequestHeader(value = "Host") String host,
                                    @RequestHeader(value = "Accept") String accept,
                                    @RequestHeader(value = "Accept-Language") String accept_language) {
        System.out.println("Host: " + host);
        System.out.println("Accept: " + accept);
        System.out.println("Accept-Language: " + accept_language);
        return "success";
    }

    @RequestMapping("cookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue) {
        System.out.println(cookieValue);
        return "success";
    }

    @RequestMapping("myCookieValue")
    public String testMyCookieValue(@CookieValue(value = "name") String myName,
                                    @CookieValue(value = "age") int myAge) {
        System.out.println("My name: " + myName + ", my age: " + myAge);
        return "success";
    }

    @RequestMapping("modelAttribute")
    public String testModelAttribute(@ModelAttribute(value = "cup") Product product) {
        System.out.println("TestModelAttribute......");
        System.out.println(product);
        return "success";
    }

    @ModelAttribute
    public void modelAttr(String productName, double price, Map<String, Product> map) {
        System.out.println("ModelAttr......");
        Product completeProduct = new Product();
        completeProduct.setProductName(productName);
        completeProduct.setPrice(price);
        completeProduct.setProductionDate(new Date());

        map.put("cup", completeProduct);
    }
}
