package com.waper.login.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName WebConfig
 * @Description 配置拦截器
 * @Author wangpeng
 * @Date 2020/11/23 15:35
 */
@EnableSwagger2
@Configuration
public class WebConfigurer implements WebMvcConfigurer {


    @Autowired
    private MyInterceptor myInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        addPathPatterns("/**")表示要拦截的请求
//        excludePathPatterns("/login","/register");// 表示排除登录和注册请求 其中/static/**","/webjars/**是静态资源
        registry.addInterceptor(myInterceptor).addPathPatterns("/**").excludePathPatterns("/login","/static/**","/webjars/**");

    }




}
