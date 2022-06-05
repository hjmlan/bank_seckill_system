package com.example.bank.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bank.vo.SecKillVo;
import org.springframework.stereotype.Service;

@Service
public interface SecondsKillService  {
    public String getVerifyHash(Integer activityId,String phoneNumber);
    public boolean check(String phoneNumber,Integer activityId,String verifyHash) throws Exception;
}
