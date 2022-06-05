package com.example.bank.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bank.mapper.AnnouncementMapper;
import com.example.bank.pojo.Announcement;
import com.example.bank.service.AnnouncementService;
import com.example.bank.utils.FormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementMapper, Announcement> implements AnnouncementService {

    @Autowired
    private AnnouncementMapper announcementMapper;

    //获取所有公告
    @Override
    public List<Announcement> getAllAnnouncement() {
        QueryWrapper<Announcement> announcementQueryWrapper = new QueryWrapper<>();
        announcementQueryWrapper.select("*").orderByDesc("releaseDate");
        List<Announcement> result = announcementMapper.selectList(announcementQueryWrapper);
        for(Announcement temp:result){
            temp.setLastUpdateTimeFormat(FormatUtil.DateFormat(temp.getLastUpdateTime()));
            temp.setReleaseDateFormat(FormatUtil.DateFormat(temp.getReleaseDate()));
        }
        return result;
    }
}
