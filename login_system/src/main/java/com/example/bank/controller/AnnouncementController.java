package com.example.bank.controller;

import com.example.bank.pojo.Announcement;
import com.example.bank.service.AnnouncementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "公告栏接口")
@RestController
@CrossOrigin
@RequestMapping("/announcement")
public class AnnouncementController {
    @Autowired
    private AnnouncementService announcementService;

    @ApiOperation(value = "加载所有公告", notes = "不需要传入JSON")
    @ApiResponses({
            @ApiResponse(code = 200, message = "关键字获取\n" +
                    "[int]id：公告编号\n" +
                    "[String]title：公告标题\n" +
                    "[String]content：公告内容\n" +
                    "[Date]releaseDate：发布日期\n" +
                    "[Date]lastUpdateTime：最后更新日期\n" +
                    "[int]adminID：发布者ID\n" +
                    "[String]imageUrl1：图片url1\n" +
                    "[String]imageUrl2：图片url2\n" +
                    "[String]imageUrl3：图片url3\n" +
                    "[String]releaseDateFormat：格式化后的releaseDateFormat\n" +
                    "[String]lastUpdateTimeFormat: 格式化后的lastUpdateTime"
            ),
    })
    @RequestMapping(value = "/getallannouncements",method = RequestMethod.POST)
    public List<Announcement> getAllAnnouncements(){
        return announcementService.getAllAnnouncement();
    }
}
