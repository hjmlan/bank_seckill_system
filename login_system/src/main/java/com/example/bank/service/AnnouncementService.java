package com.example.bank.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bank.pojo.Announcement;

import java.util.List;

public interface AnnouncementService extends IService<Announcement> {
    //获取所有公告
    List<Announcement> getAllAnnouncement();
}
