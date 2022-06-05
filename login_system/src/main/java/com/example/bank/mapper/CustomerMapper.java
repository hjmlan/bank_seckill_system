package com.example.bank.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bank.pojo.Customer;
import com.example.bank.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Mapper
@Component
public interface CustomerMapper extends BaseMapper<Customer> {
    void insertOrder (Order order);

    List<Customer> queryAll();

    Customer selectOne(String customerIdNumber);

    Customer selectByPhone(String customerPhoneNumber);

    int insertCustomer(Customer customer);

    int deleteOne(String customerIdNumber);

    int updateByPhone(@Param("customerPhoneNumber") String customerPhoneNumber, @Param("customerPassword") String customerPassword);

    int insertOneByPhone(@Param("customerPhoneNumber") String customerPhoneNumber);

    int updateRegisterDay(@Param("customerPhoneNumber") String customerPhoneNumber,@Param("customerRegisterDay") Date customerRegisterDay);

}
