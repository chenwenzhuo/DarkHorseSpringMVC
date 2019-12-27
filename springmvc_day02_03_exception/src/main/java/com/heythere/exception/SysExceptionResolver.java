package com.heythere.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse, Object o, Exception e) {
        SysException sysException = null;
        if (e instanceof SysException) {
            sysException = (SysException) e;
        }else {
            sysException = new SysException("Empty error message");
        }

        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMsg", sysException.getExceptionMsg());
        return modelAndView;
    }
}
