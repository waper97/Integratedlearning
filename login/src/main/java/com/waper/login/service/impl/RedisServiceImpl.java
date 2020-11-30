package com.waper.login.service.impl;

import com.waper.login.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName RedisService
 * @Description TODO
 * @Author wangpeng
 * @Date 2020/10/21 17:13
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 根据key获取数据
     * @param key
     * @return
     */
    @Override
    public Object get(String key){
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 设置值
     * @param key
     * @param value
     */
    @Override
    public void set(String key, Object value) {
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
         valueOperations.set(key, value);

    }

    /**
     * 根据key删除数据
     * @param key
     * @return
     */
    @Override
    public Object delete(String key){
        return redisTemplate.delete(key);
    }


}
