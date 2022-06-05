package com.example.bank.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bank.pojo.IndexImages;

import java.util.List;

public interface IndexImagesService extends IService<IndexImages> {
    //获取所有图片
    List<IndexImages> getAllImages();
}
