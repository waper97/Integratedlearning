package com.waper.login.mapper;

import com.waper.login.model.User;

import java.util.List;
import java.util.Map;

/**
 * @author 王鹏
 * @date 2020年10月20日15:48:54
 */
public interface UserMapper {

    User getUserInfo(Map<String,Object> paramMap);

    /**
     * 根据账户查询用户信息
     * @param account 用户名
     * @return
     */
    User getUserByAccount(String account);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int updateUserInfo(User user);

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    User getUserInfoById(int id);

    List<User> listUserInfo();


}
