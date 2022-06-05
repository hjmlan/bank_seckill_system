package com.example.bank.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bank.pojo.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ActivityMapper extends BaseMapper<Activity> {
    void updateActivity(Integer activityId);
}
