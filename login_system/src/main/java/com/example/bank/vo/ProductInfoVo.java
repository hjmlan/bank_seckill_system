package com.example.bank.vo;

import com.example.bank.pojo.Activity;
import com.example.bank.pojo.Productdetail;
import com.example.bank.utils.FormatUtil;

import java.util.Date;

public class ProductInfoVo {
    // 批次编号
    private Integer activityId;
    //产品编号
    private Integer productId;
    //产品名
    private String name;
    //销售渠道
    private String salesChannels;
    //起购金额
    private Long initialAmount;
    //产品期限
    private Long deadLine;
    //七日年化收益率
    private Double rateOfReturn;
    //业绩比较基准
    private Double rateOfComparative;
    //秒杀起始时间
    private Date activityStartTime;
    //秒杀结束时间
    private Date activityEndTime;
    //余量
    private Long remainAmount;
    //总量
    private Long totalAmount;
    //风险评级
    private String riskRating;
    // 限购
    private Integer purchaseEachOf;


    private String activityStartTimeFormat;

    private String activityEndTimeFormat;

    public ProductInfoVo() {
    }

    public ProductInfoVo(Productdetail productdetail){
        this.productId = productdetail.getId();
        this.name = productdetail.getName();
        this.salesChannels = productdetail.getSalesChannels();
        this.initialAmount = productdetail.getInitialAmount();
        this.deadLine = productdetail.getDeadLine();
        this.rateOfReturn = productdetail.getRateOfReturn();
        this.rateOfComparative = productdetail.getRateOfComparative();
        this.riskRating = productdetail.getRiskRating();
    }

    public ProductInfoVo(Activity activity){
        this.activityId = activity.getId();
        this.productId = activity.getProductId();
        this.activityStartTime = activity.getStartDate();
        this.activityEndTime = activity.getEndDate();
        this.totalAmount = activity.getTotalAmount();
        this.remainAmount = activity.getRemainAmount();
        this.purchaseEachOf = activity.getPurchaseEachOf();
        this.activityStartTimeFormat = FormatUtil.DateFormat(activity.getStartDate());
        this.activityEndTimeFormat = FormatUtil.DateFormat(activity.getEndDate());
    }

    public ProductInfoVo(Productdetail productdetail, Activity activity){
        this.productId = productdetail.getId();
        this.name = productdetail.getName();
        this.salesChannels = productdetail.getSalesChannels();
        this.initialAmount = productdetail.getInitialAmount();
        this.deadLine = productdetail.getDeadLine();
        this.rateOfReturn = productdetail.getRateOfReturn();
        this.rateOfComparative = productdetail.getRateOfComparative();
        this.riskRating = productdetail.getRiskRating();
        this.activityId = activity.getId();
        this.activityStartTime = activity.getStartDate();
        this.activityEndTime = activity.getEndDate();
        this.totalAmount = activity.getTotalAmount();
        this.remainAmount = activity.getRemainAmount();
        this.purchaseEachOf = activity.getPurchaseEachOf();
        this.activityStartTimeFormat = FormatUtil.DateFormat(activity.getStartDate());
        this.activityEndTimeFormat = FormatUtil.DateFormat(activity.getEndDate());
    }


    public String getActivityStartTimeFormat() {
        return activityStartTimeFormat;
    }

    public void setActivityStartTimeFormat(String activityStartTimeFormat) {
        this.activityStartTimeFormat = activityStartTimeFormat;
    }

    public String getActivityEndTimeFormat() {
        return activityEndTimeFormat;
    }

    public void setActivityEndTimeFormat(String activityEndTimeFormat) {
        this.activityEndTimeFormat = activityEndTimeFormat;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getSalesChannels() {
        return salesChannels;
    }

    public void setSalesChannels(String salesChannels) {
        this.salesChannels = salesChannels;
    }
    public Long getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(Long initialAmount) {
        this.initialAmount = initialAmount;
    }
    public Long getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Long deadLine) {
        this.deadLine = deadLine;
    }
    public Double getRateOfReturn() {
        return rateOfReturn;
    }

    public void setRateOfReturn(Double rateOfReturn) {
        this.rateOfReturn = rateOfReturn;
    }
    public Double getRateOfComparative() {
        return rateOfComparative;
    }

    public void setRateOfComparative(Double rateOfComparative) {
        this.rateOfComparative = rateOfComparative;
    }
    public Date getActivityStartTime() {
        return activityStartTime;
    }

    public void setActivityStartTime(Date activityStartTime) {
        this.activityStartTime = activityStartTime;
    }
    public Date getActivityEndTime() {
        return activityEndTime;
    }

    public void setActivityEndTime(Date activityEndTime) {
        this.activityEndTime = activityEndTime;
    }
    public Long getRemainAmount() {
        return remainAmount;
    }

    public void setRemainAmount(Long remainAmount) {
        this.remainAmount = remainAmount;
    }
    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }
    public String getRiskRating() {
        return riskRating;
    }

    public void setRiskRating(String riskRating) {
        this.riskRating = riskRating;
    }
    public Integer getPurchaseEachOf() {
        return purchaseEachOf;
    }

    public void setPurchaseEachOf(Integer purchaseEachOf) {
        this.purchaseEachOf = purchaseEachOf;
    }

    public Integer getActivityID() {
        return activityId;
    }

    public void setActivityID(Integer activityID) {
        this.activityId = activityID;
    }

    public Integer getProductID() {
        return productId;
    }

    public void setProductID(Integer productID) {
        this.productId = productID;
    }

    @Override
    public String toString() {
        return "ProductInfoVo{" +
                "activityId=" + activityId +
                ", productId=" + productId +
                ", name='" + name + '\'' +
                ", salesChannels='" + salesChannels + '\'' +
                ", initialAmount=" + initialAmount +
                ", deadLine=" + deadLine +
                ", rateOfReturn=" + rateOfReturn +
                ", rateOfComparative=" + rateOfComparative +
                ", activityStartTime=" + activityStartTime +
                ", activityEndTime=" + activityEndTime +
                ", remainAmount=" + remainAmount +
                ", totalAmount=" + totalAmount +
                ", riskRating='" + riskRating + '\'' +
                ", purchaseEachOf=" + purchaseEachOf +
                ", activityStartTimeFormat='" + activityStartTimeFormat + '\'' +
                ", activityEndTimeFormat='" + activityEndTimeFormat + '\'' +
                '}';
    }
}
