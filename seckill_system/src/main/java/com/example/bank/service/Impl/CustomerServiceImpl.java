package com.example.bank.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bank.mapper.ActivityMapper;
import com.example.bank.mapper.CustomerMapper;
import com.example.bank.mapper.OrderMapper;
import com.example.bank.mapper.ProductdetailMapper;
import com.example.bank.pojo.Activity;
import com.example.bank.pojo.Customer;
import com.example.bank.pojo.Order;
import com.example.bank.pojo.Productdetail;
import com.example.bank.service.CustomerService;
import com.example.bank.utils.DateUtil;
import com.example.bank.utils.FormatUtil;
import com.example.bank.vo.MyInfoVo;
import com.example.bank.vo.SecKillVo;
import io.netty.util.internal.StringUtil;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper,Customer> implements CustomerService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private ProductdetailMapper productdetailMapper;

    @Override
    //根据电话号码获取用户
    public Customer getCustomerByPhoneNumber(String phoneNumber) {
        if(StringUtil.isNullOrEmpty(phoneNumber)) {
            return null;
        }
        Customer customer =(Customer)redisTemplate.opsForValue().get("user:" + phoneNumber);
        if (customer.getCustomerBirthday() != null) {
            customer.setCustomerBirthdayFormat(FormatUtil.DateFormat(customer.getCustomerBirthday()));
        }
        customer.setCustomerRegisterDayFormat(FormatUtil.DateFormat(customer.getCustomerRegisterDay()));

        return customer;
    }

    @Override
    public MyInfoVo getMyInfoByPhoneNumber(String phoneNumber) {
        MyInfoVo myInfoVo = new MyInfoVo();
        if (phoneNumber == null) {
            return null;
        }
        QueryWrapper<Customer> myInfoVoQueryWrapper = new QueryWrapper<>();
        myInfoVoQueryWrapper.select("customerNumber","customerName","customerPhoneNumber","customerRegisterDay").eq("customerPhoneNumber",phoneNumber);
        Customer customer = customerMapper.selectOne(myInfoVoQueryWrapper);
        myInfoVo.setCustomerName(customer.getCustomerName());
        myInfoVo.setCustomerPhoneNumber(phoneNumber);
        //获取已购产品数量
        QueryWrapper<Order> orderQueryWrapper = new QueryWrapper<>();
        orderQueryWrapper.select("id").eq("customerId",customer.getCustomerNumber());
        Long purchasedProductNum = orderMapper.selectCount(orderQueryWrapper);
        myInfoVo.setPurchasedProductNum(purchasedProductNum);
        //获取注册年龄
        Date curDate = new Date();
        Long duration = DateUtil.BetweenDays(customer.getCustomerRegisterDay(),curDate);
        myInfoVo.setRegisterTime(duration + "天");
        return myInfoVo;
    }

    //插入订单数据并减少响应活动批次产品剩余数量
    @Override
    public void secondsKill(Integer activityId, String phoneNumber) {
        QueryWrapper<Activity> activityQueryWrapper = new QueryWrapper<>();
        activityQueryWrapper.select("*").eq("id",activityId);
        QueryWrapper<Customer> customerQueryWrapper = new QueryWrapper<>();
        customerQueryWrapper.select("customerNumber").eq("customerPhoneNumber",phoneNumber);
        Activity activity = activityMapper.selectOne(activityQueryWrapper);
        Customer customer = customerMapper.selectOne(customerQueryWrapper);
        QueryWrapper<Productdetail> productdetailQueryWrapper = new QueryWrapper<>();
        productdetailQueryWrapper.select("*").eq("id",activity.getProductId());
        Productdetail productdetail = productdetailMapper.selectOne(productdetailQueryWrapper);
        Order order = new Order();
        order.setCustomerId(customer.getCustomerNumber());
        order.setActivityId(activity.getId());
        order.setProductId(activity.getProductId());
        order.setProductPrice(productdetail.getInitialAmount());
        order.setEstimatedEarnings(productdetail.getInitialAmount() * productdetail.getRateOfReturn() / 100.0);
        Timestamp sqlDate = new Timestamp(System.currentTimeMillis());
        order.setGenerateDate(sqlDate);
        order.setStartDate(sqlDate);
        order.setEndDate(sqlDate);
        customerMapper.insertOrder(order);
        //减少活动批次产品数量
        activityMapper.updateActivity(activityId);
    }
}
