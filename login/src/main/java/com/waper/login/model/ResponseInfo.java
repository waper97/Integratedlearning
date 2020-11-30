package com.waper.login.model;

import java.io.Serializable;

/**
 * @ClassName ResponseInfo
 * @Description TODO
 * @Author wangpeng
 * @Date 2020/10/20 17:54
 */
public class ResponseInfo implements Serializable {

    private static final long serialVersionUID = 3453741511277294356L;
    public static int SUCCESS_CODE = 200;

    public static int FAILD_CODE = 499;

    private String message;

    private int status;

    private Boolean flag;

    private Object data;

    private Object other;

    public ResponseInfo() {
    }

    public ResponseInfo(String message, int status, Boolean flag, Object data, Object other) {
        this.message = message;
        this.status = status;
        this.flag = flag;
        this.data = data;
        this.other = other;
    }

    public ResponseInfo(String message, int status, Boolean flag) {
        this.message = message;
        this.status = status;
        this.flag = flag;
    }

    public ResponseInfo(String message, int status, Boolean flag, Object data) {
        this.message = message;
        this.status = status;
        this.flag = flag;
        this.data = data;
    }



    public static int getSuccessCode() {
        return SUCCESS_CODE;
    }

    public static void setSuccessCode(int successCode) {
        SUCCESS_CODE = successCode;
    }

    public static int getFaildCode() {
        return FAILD_CODE;
    }

    public static void setFaildCode(int faildCode) {
        FAILD_CODE = faildCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getOther() {
        return other;
    }

    public void setOther(Object other) {
        this.other = other;
    }
}
