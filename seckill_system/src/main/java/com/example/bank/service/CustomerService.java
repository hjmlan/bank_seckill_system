package com.example.bank.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bank.pojo.Customer;
import com.example.bank.vo.MyInfoVo;
import com.example.bank.vo.SecKillVo;

public interface CustomerService extends IService<Customer> {
    //根据手机号获取用户信息
    Customer getCustomerByPhoneNumber(String phoneNumber);
    //根据登录的用户获取账号、注册年龄、已购产品数量
    MyInfoVo getMyInfoByPhoneNumber(String phoneNumber);
    //根据活动批次编号进行秒杀
    void secondsKill(Integer activityId, String phoneNumber);
}
