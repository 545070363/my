package com.superbug.jvm.Interceptor;

import com.superbug.jvm.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class SuperInterceptor implements HandlerInterceptor {
    private static Logger logger = LoggerFactory.getLogger(SuperInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long time = new Date().getTime();
        request.setAttribute("time",time);
        logger.info("请求接口 -----> " + request.getRequestURI());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long time = (long)request.getAttribute("time");
        long time2 = new Date().getTime();
        long t = (time2 - time);
        logger.info("响应时间 ----> " + t + " ms");
    }
}
