package com.example.bank.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bank.pojo.FrequentlyAQ;

import java.util.List;

public interface FrequentlyAQService extends IService<FrequentlyAQ> {
    //获取所有常见问题解答
    List<FrequentlyAQ> getAllFrequentlyAQ();
}
