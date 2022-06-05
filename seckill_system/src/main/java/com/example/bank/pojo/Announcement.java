package com.example.bank.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

public class Announcement implements Serializable {
    private static final long serialVersionUID = 1L;
    //公告编号
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    //发布者
    @TableField("adminId")
    private Integer adminId;
    //公告标题
    private String title;
    //公告内容
    private String content;
    //发布时间
    @TableField("releaseDate")
    private Date releaseDate;
    //最后更新时间
    @TableField("lastUpdateTime")
    private Date lastUpdateTime;
    //pdf跳转地址
    @TableField("pdfUrl")
    private String pdfUrl;
    @TableField("imageUrl1")
    private String imageUrl1;
    @TableField("imageUrl2")
    private String imageUrl2;
    @TableField("imageUrl3")
    private String imageUrl3;

    private String lastUpdateTimeFormat;

    private String releaseDateFormat;

    public String getReleaseDateFormat() {
        return releaseDateFormat;
    }

    public void setReleaseDateFormat(String releaseDateFormat) {
        this.releaseDateFormat = releaseDateFormat;
    }

    public String getLastUpdateTimeFormat() {
        return lastUpdateTimeFormat;
    }

    public void setLastUpdateTimeFormat(String lastUpdateTimeFormat) {
        this.lastUpdateTimeFormat = lastUpdateTimeFormat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getAdminID() {
        return adminId;
    }

    public void setAdminID(Integer adminId) {
        this.adminId = adminId;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }
    public String getImageUrl1() {
        return imageUrl1;
    }

    public void setImageUrl1(String imageUrl1) {
        this.imageUrl1 = imageUrl1;
    }
    public String getImageUrl2() {
        return imageUrl2;
    }

    public void setImageUrl2(String imageUrl2) {
        this.imageUrl2 = imageUrl2;
    }
    public String getImageUrl3() {
        return imageUrl3;
    }

    public void setImageUrl3(String imageUrl3) {
        this.imageUrl3 = imageUrl3;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "id=" + id +
                ", adminId=" + adminId +
                ", title=" + title +
                ", content=" + content +
                ", releaseDate=" + releaseDate +
                ", lastUpdateTime=" + lastUpdateTime +
                ", pdfUrl=" + pdfUrl +
                ", imageUrl1=" + imageUrl1 +
                ", imageUrl2=" + imageUrl2 +
                ", imageUrl3=" + imageUrl3 +
                "}";
    }
}
