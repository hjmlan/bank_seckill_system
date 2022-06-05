package com.example.bank.service.Impl;

import com.example.bank.mapper.CustomerMapper;
import com.example.bank.pojo.Key;
import com.example.bank.service.SecondsKillService;
import com.example.bank.utils.RedisUtil;
import com.example.bank.vo.SecKillVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PathVariable;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

@Service
public class SecondsKillServiceImpl implements SecondsKillService {
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public String getVerifyHash(Integer activityId,String phoneNumber){
        String verify = Key.firstKey.getKey() + phoneNumber + activityId;
        String verifyHash = DigestUtils.md5DigestAsHex(verify.getBytes());

        String hashKey = Key.verifyKey.getKey() + "_" + phoneNumber + "_" + activityId;
        redisTemplate.opsForValue().set(hashKey,verifyHash,600, TimeUnit.SECONDS);
        System.out.println("校验码为:"+ verifyHash);

        return verifyHash;
    }

    @Override
    public boolean check(String phoneNumber,Integer activityId,String verifyHash) throws Exception{
        String hashKey = Key.verifyKey.getKey() + "_" + phoneNumber + "_" + activityId;
        String verifyHashInRedis = (String) redisTemplate.opsForValue().get(hashKey);
        System.out.println("缓存校验码为:"+ verifyHashInRedis);
        System.out.println("实际校验码为:"+ verifyHash);
        if(verifyHashInRedis == null){
            throw new RuntimeException("请获取校验码后重试");
        }
        if(!verifyHash.equals(verifyHashInRedis)){
            throw new RuntimeException("校验码有误，请重试");
        }
         return true;
    }

}
