package com.example.bank.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bank.pojo.Customer;
import com.example.bank.pojo.Order;

public interface CustomerMapper extends BaseMapper<Customer> {
    void insertOrder (Order order);
}
