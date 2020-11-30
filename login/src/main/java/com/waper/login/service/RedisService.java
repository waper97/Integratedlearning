package com.waper.login.service;

public interface RedisService {

    public Object get(String key);

    /**
     * 设置值
     * @param key
     * @param value
     */
    public void set(String key, Object value);

    /**
     * 根据key删除数据
     * @param key
     * @return
     */
    public Object delete(String key);
}
