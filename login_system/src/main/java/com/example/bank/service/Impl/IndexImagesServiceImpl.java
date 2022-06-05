package com.example.bank.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bank.mapper.IndexImagesMapper;
import com.example.bank.pojo.IndexImages;
import com.example.bank.service.IndexImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexImagesServiceImpl extends ServiceImpl<IndexImagesMapper, IndexImages> implements IndexImagesService {
    @Autowired
    private IndexImagesMapper indexImagesMapper;

    @Override
    public List<IndexImages> getAllImages() {
        QueryWrapper<IndexImages> indeximagesQueryWrapper = new QueryWrapper<>();
        indeximagesQueryWrapper.select("*").orderByAsc("id");
        List<IndexImages> result = indexImagesMapper.selectList(indeximagesQueryWrapper);
        return result;
    }
}
