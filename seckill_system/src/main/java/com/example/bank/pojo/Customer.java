package com.example.bank.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    //客户编号
    @TableId(value = "customerNumber", type = IdType.AUTO)
    private Integer customerNumber;

    //客户姓名
    private String customerName;

    //客户身份证类型
    private String customerIdType;

    //客户身份证号
    private String customerIdNumber;

    //客户手机号
    private String customerPhoneNumber;

    //客户密码
    private String customerPassword;

    //客户邮箱
    private String customerEmail;

    //客户地址
    private String customerAddress;

    //客户性别
    private String customerSex;

    //客户职业
    private String customerOccupation;

    //客户生日
    private Date customerBirthday;

    //客户注册日
    private Date customerRegisterDay;

    //客户绑定的银行卡
    private String customerBankCard;

    //银行卡支付密码
    private String bankCardPassword;

    //余额
    private BigDecimal balance;

    private String customerBirthdayFormat;
    private String customerRegisterDayFormat;

    public String getCustomerBirthdayFormat() {
        return customerBirthdayFormat;
    }

    public void setCustomerBirthdayFormat(String customerBirthdayFormat) {
        this.customerBirthdayFormat = customerBirthdayFormat;
    }

    public String getCustomerRegisterDayFormat() {
        return customerRegisterDayFormat;
    }

    public void setCustomerRegisterDayFormat(String customerRegisterDayFormat) {
        this.customerRegisterDayFormat = customerRegisterDayFormat;
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerIdType() {
        return customerIdType;
    }

    public void setCustomerIdType(String customerIdType) {
        this.customerIdType = customerIdType;
    }
    public String getCustomerIdNumber() {
        return customerIdNumber;
    }

    public void setCustomerIdNumber(String customerIdNumber) {
        this.customerIdNumber = customerIdNumber;
    }
    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }
    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }
    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
    public String getCustomerSex() {
        return customerSex;
    }

    public void setCustomerSex(String customerSex) {
        this.customerSex = customerSex;
    }
    public String getCustomerOccupation() {
        return customerOccupation;
    }

    public void setCustomerOccupation(String customerOccupation) {
        this.customerOccupation = customerOccupation;
    }
    public Date getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(Date customerBirthday) {
        this.customerBirthday = customerBirthday;
    }
    public Date getCustomerRegisterDay() {
        return customerRegisterDay;
    }

    public void setCustomerRegisterDay(Date customerRegisterDay) {
        this.customerRegisterDay = customerRegisterDay;
    }
    public String getCustomerBankCard() {
        return customerBankCard;
    }

    public void setCustomerBankCard(String customerBankCard) {
        this.customerBankCard = customerBankCard;
    }
    public String getBankCardPassword() {
        return bankCardPassword;
    }

    public void setBankCardPassword(String bankCardPassword) {
        this.bankCardPassword = bankCardPassword;
    }
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerNumber=" + customerNumber +
                ", customerName=" + customerName +
                ", customerIdType=" + customerIdType +
                ", customerIdNumber=" + customerIdNumber +
                ", customerPhoneNumber=" + customerPhoneNumber +
                ", customerPassword=" + customerPassword +
                ", customerEmail=" + customerEmail +
                ", customerAddress=" + customerAddress +
                ", customerSex=" + customerSex +
                ", customerOccupation=" + customerOccupation +
                ", customerBirthday=" + customerBirthday +
                ", customerRegisterDay=" + customerRegisterDay +
                ", customerBankCard=" + customerBankCard +
                ", bankCardPassword=" + bankCardPassword +
                ", balance=" + balance +
                "}";
    }
}
