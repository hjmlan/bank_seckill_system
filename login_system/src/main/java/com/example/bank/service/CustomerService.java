package com.example.bank.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bank.pojo.Customer;
import com.example.bank.vo.MyInfoVo;
import com.example.bank.vo.SecKillVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface CustomerService extends IService<Customer> {
    //根据手机号获取用户信息
    Customer getCustomerByPhoneNumber(String phoneNumber);
    //根据登录的用户获取账号、注册年龄、已购产品数量
    MyInfoVo getMyInfoByPhoneNumber(String phoneNumber);
    //根据活动批次编号进行秒杀
    void secondsKill(Integer activityId, String phoneNumber,String verifyHash);

    List<Customer> queryAll();

    boolean login(Customer customer);

    boolean enroll(Customer customer);

    Customer selectOne(String customerIdNumber);

    Customer selectByPhone(String customerPhoneNumber);

    int deleteOne(String customerIdNumber);

    int updateByPhone(@Param("customerPhoneNumber") String customerPhoneNumber, @Param("customerPassword") String customerPassword);

    int insertOneByPhone(@Param("customerPhoneNumber") String customerPhoneNumber);

    int updateRegisterDay(@Param("customerPhoneNumber") String customerPhoneNumber,@Param("customerRegisterDay") Date customerRegisterDay);


}
