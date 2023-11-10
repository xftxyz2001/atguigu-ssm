package com.atguigu.json;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * projectName: com.atguigu.json
 *
 * @author: 赵伟风
 * description:
 */
public class EncodingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("application/json;charset=utf-8");
        return true;
    }
}
