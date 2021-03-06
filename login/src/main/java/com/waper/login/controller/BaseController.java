package com.waper.login.controller;

import com.waper.login.model.ResponseInfo;
import io.swagger.annotations.Api;
import org.springframework.util.DigestUtils;

import java.io.IOException;

/**
 * @ClassName BaseController
 * @Description 基础操作
 * @Author wangpeng
 * @Date 2020/10/20 17:53
 */
@Api(value = "基础操作，其他类基于它")
public class BaseController {


    public ResponseInfo success(String message){
        return new ResponseInfo(message,ResponseInfo.SUCCESS_CODE,true);
    }

    public ResponseInfo successData(String message, Object data){
        return new ResponseInfo(message,ResponseInfo.SUCCESS_CODE,true,data);
    }

    public ResponseInfo successData(String message, Object data,Object otherData){
        return new ResponseInfo(message,ResponseInfo.SUCCESS_CODE,true,data,otherData);
    }

    public ResponseInfo faild(String message){
        return new ResponseInfo(message,ResponseInfo.FAILD_CODE,false);
    }


    public static void main(String[] args) throws IOException {
        System.out.println(DigestUtils.md5DigestAsHex("123456".getBytes()));

    }
}
