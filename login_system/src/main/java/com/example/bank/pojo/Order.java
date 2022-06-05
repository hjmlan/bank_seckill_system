package com.example.bank.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

@TableName(value = "orders")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    //订单id
    @TableId("id")
    private String id;

    //客户编号
    @TableField("customerId")
    private Integer customerId;

    //产品编号
    @TableField("productId")
    private Integer productId;


    //购入金额
    @TableField("productPrice")
    private Long productPrice;

    //预估收益
    @TableField("estimatedEarnings")
    private Double estimatedEarnings;

    //支付途径,1支付宝2微信支付3三湘银行卡支付
    @TableField("orderChannel")
    private Integer orderChannel;

    //订单状态,0未支付1已支付3存款期间4已结束
    private Integer status;

    //下单时间
    @TableField("generateDate")
    private Date generateDate;

    //支付时间
    @TableField("payDate")
    private Date payDate;

    //开始日期
    @TableField("startDate")
    private Date startDate;

    //结束日期
    @TableField("endDate")
    private Date endDate;

    //活动批次id
    @TableField("activityId")
    private Integer activityId;

    public Integer getActivityId() {
        return activityId;
    }
    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getProductId() {
        return productId;
    }
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Long getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }

    public Double getEstimatedEarnings() {
        return estimatedEarnings;
    }
    public void setEstimatedEarnings(Double estimatedEarnings) {
        this.estimatedEarnings = estimatedEarnings;
    }

    public Integer getOrderChannel() {
        return orderChannel;
    }
    public void setOrderChannel(Integer orderChannel) {
        this.orderChannel = orderChannel;
    }

    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getGenerateDate() {
        return generateDate;
    }
    public void setGenerateDate(Date generateDate) {
        this.generateDate = generateDate;
    }

    public Date getPayDate() {
        return payDate;
    }
    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customerId=" + customerId +
                ", productId=" + productId +
                ", productPrice=" + productPrice +
                ", estimatedEarnings=" + estimatedEarnings +
                ", orderChannel=" + orderChannel +
                ", status=" + status +
                ", generateDate=" + generateDate +
                ", payDate=" + payDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", activityId=" + activityId +
                '}';
    }
}
