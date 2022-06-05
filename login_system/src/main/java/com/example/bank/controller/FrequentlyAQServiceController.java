package com.example.bank.controller;

import com.example.bank.pojo.FrequentlyAQ;
import com.example.bank.service.FrequentlyAQService;
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

@Api(tags = "常见问题解答接口")
@RestController
@CrossOrigin
@RequestMapping("/frequently-aq")
public class FrequentlyAQServiceController {
    @Autowired
    private FrequentlyAQService frequentlyAQService;

    @ApiOperation(value = "常见问题获取", notes = "无需传递参数")
    @ApiResponses({
            @ApiResponse(code = 200, message = "关键字获取\n" +
                    "[Long]id：常见问题id\n" +
                    "[String]question：常见问题\n" +
                    "[String]answer：回答\n"
            ),
    })

    @RequestMapping(value = "/getallaq",method = RequestMethod.POST)
    public List<FrequentlyAQ> getAllAQ(){
        return frequentlyAQService.getAllFrequentlyAQ();
    }
}
