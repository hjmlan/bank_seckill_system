package com.example.bank.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bank.mapper.FrequentlyAQMapper;
import com.example.bank.pojo.FrequentlyAQ;
import com.example.bank.service.FrequentlyAQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FrequentlyAQServiceImpl extends ServiceImpl<FrequentlyAQMapper, FrequentlyAQ> implements FrequentlyAQService {
    @Autowired
    private FrequentlyAQMapper frequentlyAQMapper;

    @Override
    public List<FrequentlyAQ> getAllFrequentlyAQ() {
        QueryWrapper<FrequentlyAQ> frequentlyAQQueryWrapper = new QueryWrapper<>();
        frequentlyAQQueryWrapper.select("*");
        return frequentlyAQMapper.selectList(frequentlyAQQueryWrapper);
    }
}
