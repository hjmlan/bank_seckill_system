package com.example.bank.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component("redisUtil")
public class RedisUtil {
    private RedisTemplate<String,Object> redisTemplate;
    public void setRedisTemplate(RedisTemplate<String,Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }
    public  void set(String key,Object value){
        try {
            redisTemplate.opsForValue().set(key, value);
//            return true;
        } catch (Exception e) {
            e.printStackTrace();
//            return false;
        }

    }
    public Object get(String key){
        return key==null?null:redisTemplate.opsForValue().get(key);
    }

}
