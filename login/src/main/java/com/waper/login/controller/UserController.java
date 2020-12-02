package com.waper.login.controller;

import com.waper.login.model.User;
import com.waper.login.service.RedisService;
import com.waper.login.service.UserService;
import com.waper.login.util.JwtUtil;
import com.zhenzi.sms.ZhenziSmsClient;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author wangpeng
 * @Date 2020/10/20 15:47
 */
@Api("用户Controller")
@RestController
@RequestMapping("api/user")
public class UserController extends BaseController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    public static final String apiUrl = "https://sms_developer.zhenzikj.com";
    public static final String appId = "107255";
    public static final String appSecret = "61c7e18d-2f91-4ce2-bc8b-c71481469c65";

    @Resource
    UserService userService;

    @Resource
    RedisService redisService;
    @ApiOperation(value = "用户登录接口",httpMethod = "POST",notes = "用户登录")
    @ApiImplicitParams(
            { @ApiImplicitParam(name = "account", value = "账号入参", dataType = "String", required = true),
                    @ApiImplicitParam(name = "password", value = "密码入参", dataType = "String", required = true)
            }
    )
    @PostMapping("login")
    public Object userLogin(String account, String password){

        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password)) {
            return "账号或密码不能为空!";
        }
        // 加密密码
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (userService.getUserInfo(account,password) == null) {
            return faild("账号或密码错误!");
        }
        User userInfo = userService.getUserInfo(account,password);

        // 生成TOKEN
        String token = (String)JwtUtil.createToken(userInfo);
        redisService.set(token,userInfo);
        return successData("获取成功",userInfo,token);
    }

    /**
     *
     * @param mobile 电话号码
     * @return
     */
    @GetMapping("sendSms")
    public Object  sendSms(String mobile, HttpSession session) throws Exception {
        if (StringUtils.isEmpty(mobile)) {
            return faild("手机号码不能为空!");
        }
        ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, appId, appSecret);
        Map<String, Object> params = new HashMap<String, Object>(16);
        params.put("number", mobile);
        // 短信模板id
        params.put("templateId", "2422");
        String[] templateParams = new String[2];
        templateParams[0] = "7424";
        templateParams[1] = "5分钟";
        params.put("templateParams", templateParams);
        String result = client.send(params);
        logger.info(result);
        return success("发送成功!");
    }

    @GetMapping("smsLogin")
    public Object  smsLogin(String mobile, String sms,HttpSession session) throws Exception {
        if (StringUtils.isEmpty(mobile) && StringUtils.isEmpty(sms)) {
            return faild("手机号码或短信验证码不能为空!");
        }

        return success("发送成功!");
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @PostMapping("updateInfo")
    @ApiOperation(value = "更新用户信息接口", notes = "更新用户信息")
    public Object updateUserInfo(User user){
        if (StringUtils.isEmpty(user.getId())) {
            return faild("id不能为空!");
        }

        User userInfo = userService.getUserInfoById(user.getId());
        if (userInfo == null) {
            return faild("用户不存在!");
        }

        int result = userService.updateUserInfo(user);
        return success("修改成功");
    }



    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id获取用户信息接口", notes ="根据id获取用户信息")
    @ApiImplicitParam(name = "id",value = "id",dataType = "Integer")
    @GetMapping("getUserInfoById")
    public Object getUserInfoById(Integer id){
        if (id == null) {
            return faild("id不能为空");
        }
        User userInfo = userService.getUserInfoById(id);
        if (userInfo == null) {
            return faild("参数有数请重试!");
        }
        return successData("获取成功",userInfo);
    }

    /**
     * 修改密码
     * @param id
     * @param olderPassword
     * @param newPassword
     * @return
     */
    @ApiOperation(value = "修改密码接口", notes ="修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "id",dataType = "String"),
            @ApiImplicitParam(name = "account",value = "账号",dataType = "String"),
            @ApiImplicitParam(name = "olderPassword",value = "旧密码",dataType = "String"),
            @ApiImplicitParam(name = "newPassword",value = "新密码",dataType = "String")
    })
    @PostMapping("updatePassword")
    public Object updatePassword(Integer id ,String account ,String olderPassword, String newPassword){
        if (StringUtils.isEmpty(id)) {
            return faild("id不能为空!");
        }
        if (StringUtils.isEmpty(olderPassword))  {
            return faild("旧密码不能为空!");
        }
        if (StringUtils.isEmpty(newPassword))  {
            return faild("新密码不能为空!");
        }

        User user =  userService.getUserByAccount(account);

        if (user == null) {
            return faild("用户不存在");
        }
        if (!olderPassword.equals(user.getPassword())) {
            return faild("旧密码错误!");
        }
        User newUser = new User();
        user.setId(id);
        user.setPassword(newPassword);
        userService.updateUserInfo(newUser);
        return success("修改成功!");
    }

    @ApiOperation(value = "测试接口",notes = "测试")
    @GetMapping("test")
    public String test(){
        System.out.println("test");



        return "test";
    }
    @ApiOperation(value = "获取用户列表接口",notes = "获取用户列表")
    @GetMapping("listUserInfo")
    public Object listUser(){
        List<User> list = userService.listUserInfo();
        return successData("获取成功",list);
    }

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
    }

}

