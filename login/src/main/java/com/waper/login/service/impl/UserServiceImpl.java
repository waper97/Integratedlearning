package com.waper.login.service.impl;

import com.waper.login.mapper.UserMapper;
import com.waper.login.model.User;
import com.waper.login.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author wangpeng
 * @Date 2020/10/20 16:14
 */
@Service
public class UserServiceImpl  implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserInfo(String account, String password) {
        Map<String,Object> paramMap = new HashMap<>(16);
        paramMap.put("account",account);
        paramMap.put("password",password);
        return userMapper.getUserInfo(paramMap);
    }

    @Override
    public User getUserByAccount(String account) {
        return userMapper.getUserByAccount(account);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateUserInfo(User user) {
        return userMapper.updateUserInfo(user);
    }

    @Override
    public User getUserInfoById(int id) {
        return userMapper.getUserInfoById(id);
    }

    @Override
    public List<User> listUserInfo() {
        return userMapper.listUserInfo();
    }


}
