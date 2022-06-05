package com.example.bank.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;

    //活动批次编号
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    //产品编号
    @TableField("productId")
    private Integer productId;

    //活动开始时间
    @TableField("startDate")
    private Date startDate;

    //活动结束时间
    @TableField("endDate")
    private Date endDate;

    //总量
    @TableField("totalAmount")
    private Long totalAmount;

    //余量
    @TableField("remainAmount")
    private Long remainAmount;

    //限购
    @TableField("purchaseEachOf")
    private Integer purchaseEachOf;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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
    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }
    public Long getRemainAmount() {
        return remainAmount;
    }

    public void setRemainAmount(Long remainAmount) {
        this.remainAmount = remainAmount;
    }
    public Integer getPurchaseEachOf() {
        return purchaseEachOf;
    }

    public void setPurchaseEachOf(Integer purchaseEachOf) {
        this.purchaseEachOf = purchaseEachOf;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", productID=" + productId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", totalAmount=" + totalAmount +
                ", remainAmount=" + remainAmount +
                ", purchaseEachOf=" + purchaseEachOf +
                "}";
    }
}
