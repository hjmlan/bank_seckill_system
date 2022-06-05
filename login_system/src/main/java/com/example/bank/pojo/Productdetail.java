package com.example.bank.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

public class Productdetail implements Serializable {

    private static final long serialVersionUID = 1L;

    //产品编号
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    //产品名称
    private String name;

    //销售渠道
    @TableField("salesChannels")
    private String salesChannels;

    //起始金额
    @TableField("initialAmount")
    private Long initialAmount;

    //产品期限
    @TableField("deadLine")
    private Long deadLine;

    //收益率
    @TableField("rateOfReturn")
    private Double rateOfReturn;

    //业绩比较基准
    @TableField("rateOfComparative")
    private Double rateOfComparative;

    //风险评级
    @TableField("riskRating")
    private String riskRating;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    public String getRiskRating() {
        return riskRating;
    }

    public void setRiskRating(String riskRating) {
        this.riskRating = riskRating;
    }

    @Override
    public String toString() {
        return "Productdetail{" +
                "id=" + id +
                ", name=" + name +
                ", salesChannels=" + salesChannels +
                ", initialAmount=" + initialAmount +
                ", deadLine=" + deadLine +
                ", rateOfReturn=" + rateOfReturn +
                ", rateOfComparative=" + rateOfComparative +
                ", riskRating=" + riskRating +
                "}";
    }
}
