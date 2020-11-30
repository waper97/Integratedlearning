package com.waper.login.service;

import com.waper.login.model.User;

import java.util.List;
import java.util.Map;

/**
 * @author wangpeng
 * @date 2020年10月20日16:13:29
 *
 */
public interface UserService {
    /**
     * 根据账户密码查询用户信息
     * @param account
     * @param password
     * @return
     */
    User getUserInfo(String account, String password);
    /**
     * 根据账户询用户信息
     * @param account
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
