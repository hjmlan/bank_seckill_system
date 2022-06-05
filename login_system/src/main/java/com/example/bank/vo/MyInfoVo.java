package com.example.bank.vo;

public class MyInfoVo {
    private String customerPhoneNumber;
    private String registerTime;
    private Long purchasedProductNum;
    private String customerName;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public Long getPurchasedProductNum() {
        return purchasedProductNum;
    }

    public void setPurchasedProductNum(Long purchasedProductNum) {
        this.purchasedProductNum = purchasedProductNum;
    }
}
