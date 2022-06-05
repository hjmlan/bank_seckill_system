package com.example.bank.controller;

import com.example.bank.pojo.IndexImages;
import com.example.bank.service.IndexImagesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "首页图片接口")
@RestController
@CrossOrigin
@RequestMapping("/indeximages")
public class IndexImagesController {
    @Autowired
    private IndexImagesService indeximagesService;

    @ApiOperation(value = "读取所有图片并显示", notes = "不需要传入JSON，返回数据格式:\n" +
            "[Integer]id: 图片编号\n" +
            "[String]imageUrl: 图片url\n")
    @RequestMapping(value = "/loadallimages",method = RequestMethod.GET)
    public List<IndexImages> loadAllImages(){
        return indeximagesService.getAllImages();
    }
}
