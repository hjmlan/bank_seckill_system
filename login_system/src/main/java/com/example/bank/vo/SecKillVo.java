package com.example.bank.vo;

import lombok.Data;

@Data
public class SecKillVo {
    private String phoneNumber;
    private Integer activityId;
    private String verifyHash;  //校验码

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getVerifyHash() { return verifyHash; }

    public void setVerifyHash(String verifyHash) { this.verifyHash = verifyHash; }
}
