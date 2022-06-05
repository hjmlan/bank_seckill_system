package com.example.bank.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

@TableName("indeximages")
public class IndexImages implements Serializable {

    private static final long serialVersionUID = 1L;

    //主键
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    //图片地址
    @TableField("imageUrl")
    private String imageUrl;

    //上架图片日期设定
    @TableField("startDate")
    private Date startDate;

    //下架图片日期设定
    @TableField("endDate")
    private Date endDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
        return "Indeximages{" +
                "id=" + id +
                ", imageUrl=" + imageUrl +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                "}";
    }
}
