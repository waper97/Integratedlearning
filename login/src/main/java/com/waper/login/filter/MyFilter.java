//package com.waper.login.filter;
//
//import com.alibaba.fastjson.JSONObject;
//import com.waper.login.common.StaticValue;
//import com.waper.login.util.JwtUtil;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Controller;
//import org.springframework.util.StringUtils;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @ClassName MyFilter
// * @Description TODO
// * @Author wangpeng
// * @Date 2020/10/22 15:03
// */
//@Component
//public class MyFilter  implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
//        Map<String,Object> map = new HashMap<>(16);
//        String url = ((HttpServletRequest)request).getRequestURI();
////        if (!StaticValue.DEBUG) {
////            if (url !=  null) {
////                // 登录直接放心
////                if ("/api/user/login".equals(url)) {
////                    filterChain.doFilter(request,response);
////                    return ;
////                }else{
////                    // 其他接口验证token
////                    String token = ((HttpServletRequest) request).getHeader("token");
////                    if (!StringUtils.isEmpty(token)) {
////                        JwtUtil util = new JwtUtil();
////                        boolean result = JwtUtil.verifyToken(token);
////                        if (result) {
////                            // 放行
////                            filterChain.doFilter(request,response);
////                            return ;
////                        }else{
////
////                            map.put("msg","用户验证失败");
////                        }
////                    }else{
////                        map.put("msg","未携带token信息");
////                    }
////                }
////            }
////            JSONObject jsonObject = new JSONObject(map);
////            response.setContentType("application/json");
////            response.setCharacterEncoding("UTF-8");
////            // 响应
////            PrintWriter pw = response.getWriter();
////            pw.write(jsonObject.toJSONString());
////            pw.flush();
////            pw.close();
////        }
//    }
//}
