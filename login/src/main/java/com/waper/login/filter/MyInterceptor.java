package com.waper.login.filter;

import com.alibaba.fastjson.JSONObject;
import com.waper.login.common.StaticValue;
import com.waper.login.model.ResponseInfo;
import com.waper.login.util.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @ClassName MyInterceptor
 * @Description 自定义拦截器
 * @Author wangpeng
 * @Date 2020/11/23 15:24
 */
@Component
public class MyInterceptor extends HandlerInterceptorAdapter {


    private ResponseInfo responseInfo = null;
    // 输出流
    PrintWriter printWriter;
    /**
     * This implementation always returns {@code true}.
     *请求前拦截
     * @param request
     * @param response
     * @param handler
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (StaticValue.DEBUG) {
            return true;
        }else {
            if (request.getMethod().equals("OPTIONS")) {
                System.out.println("options方法");
                return true;
            }
            String token = request.getHeader("Authorization");
            String url = request.getRequestURI();
            if ("login".endsWith(url) || "logout".endsWith(url)) {
                return true;
            } else {
                // 校验token
                boolean result = JwtUtil.verifyToken(token);
                if (result) {
                    return true;
                } else{
                    PrintWriter printWriter = response.getWriter();
                    printWriter.write(JSONObject.toJSONString(responseInfo));
                    return false;
                }
            }
        }
    }

    /**
     * This implementation is empty.
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
}
