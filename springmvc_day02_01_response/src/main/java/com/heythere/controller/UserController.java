package com.heythere.controller;

import com.heythere.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(path = "user")
public class UserController {
    @RequestMapping(path = "testString")
    public String testString(Model model) {
        System.out.println("Inside testString......");
        //创建对象，模拟从数据库中查询数据
        User zhangsan = new User();
        zhangsan.setUsername("张三");
        zhangsan.setPassword("zhangsan.pwd");
        zhangsan.setAge(20);

        //将数据封装进Model
        model.addAttribute("userZhangsan", zhangsan);
        return "success";
    }

    @RequestMapping(path = "testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("Inside testVoid......");

        //内部转发
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);

        //重定向
        /*重定向相当于重新发请求，
        * 由于不能直接请求 /WEB-INF 目录下的页面，所以只能请求 /webapp 目录下的页面*/
        //response.sendRedirect(request.getContextPath() + "/index.jsp");

        //直接对浏览器响应
        //设置字符集，解决中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print("哈哈");
    }

    @RequestMapping(path = "testModelAndView")
    public ModelAndView testModelAndView(ModelAndView modelAndView) {
        System.out.println("Inside testModelAndView......");
        //创建对象，模拟从数据库中查询数据
        User lisi = new User();
        lisi.setUsername("李四");
        lisi.setPassword("lisi.pwd");
        lisi.setAge(23);

        //将数据封装进ModelAndView
        modelAndView.addObject("userLisi", lisi);

        //设置要跳转的视图
        modelAndView.setViewName("success");

        return modelAndView;
    }

    @RequestMapping(path = "testForwardAndRedirect")
    public String testForwardAndRedirect() {
        System.out.println("Inside testForwardAndRedirect......");

        //使用forward关键字进行转发
        //return "forward:/WEB-INF/pages/success.jsp";

        //使用redirect关键字进行重定向
        return "redirect:/index.jsp";
    }
}
