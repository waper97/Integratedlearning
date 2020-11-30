package com.waper.login.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName User
 * @Description TODO
 * @Author wangpeng
 * @Date 2020/10/20 15:49
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1934436324554233243L;
    /**
     * id
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 账户
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 电话
     */
    private String mobile;
    /**
     * 地址
     */
    private String address;
    /**
     * 性别 0女，1男
     */
    private Integer sex;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 头像
     */
    private String profilePath;
}
