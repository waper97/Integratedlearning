package com.waper.login.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName User
 * @Description TODO
 * @Author wangpeng
 * @Date 2020/10/20 15:49
 */
@Data
@ApiModel("用户类")
public class User implements Serializable {

    private static final long serialVersionUID = 1934436324554233243L;
    /**
     * id
     */
    @ApiModelProperty("id")
    private Integer id;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称",name = "name", required = true ,example = "fuck")
    @NotBlank(message ="名称不能为空")
    private String name;
    /**
     * 账户
     */
    @ApiModelProperty(value = "账号",name = "account", required = true ,example = "admin")
    @NotBlank(message ="名称不能为空")
    private String account;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码",name = "password", required = true ,example = "admin")
    @NotBlank(message ="密码不能为空")
    private String password;
    /**
     * 电话
     */
    @ApiModelProperty(value = "电话",name = "mobile",example = "183 xxx xxxxx")
    private String mobile;
    /**
     * 地址
     */
    @ApiModelProperty(value = "地址",name = "address",example = "183 xxx xxxxx")
    private String address;
    /**
     * 性别 0女，1男
     */
    @ApiModelProperty(value = "性别,0女,1男",name = "sex")
    private Integer sex;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态:0正常，1删除",name = "sex")
    private Integer status;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间",name = "createTime",required = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 头像
     */
    @ApiModelProperty(value = "头像",name = "profilePath")
    private String profilePath;
}
