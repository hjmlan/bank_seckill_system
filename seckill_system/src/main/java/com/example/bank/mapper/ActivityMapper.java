package com.example.bank.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bank.pojo.Activity;

public interface ActivityMapper extends BaseMapper<Activity> {
    void updateActivity(Integer activityId);
}
