package com.waper.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName RedirectController
 * @Description 重定向controller
 * @Author wangpeng
 * @Date 2020/11/6 10:03
 */
@Controller
public class RedirectController {
    /**
     * 登录页面
     * @return
     */
    @RequestMapping("login")
    public String login(){
        return "login";
    }

    /**
     * 短信登录界面
     * @return
     */
    @RequestMapping("messageLogin")
    public String messageLogin(){
        return "messageLogin";
    }

    /**
     * 主页面
     * @return
     */
    @RequestMapping("index")
    public String index(){
        return "index";
    }

}
