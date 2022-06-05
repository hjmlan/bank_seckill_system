package com.example.bank.controller;

import com.example.bank.pojo.Customer;
import com.example.bank.service.CustomerService;
import com.example.bank.vo.MyInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户接口")
@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @ApiOperation(value = "获取当前登录的用户", notes = "前端需传递请求后缀带上手机号码，例如customer/getcustomerbbyphonenumber/15858223459")
    @ApiResponses({
            @ApiResponse(code = 200, message = "关键字获取\n" +
                    "[int]customerNumber：客户编号\n" +
                    "[String]customerName：客户姓名\n" +
                    "[String]customerIdType：客户身份证类型\n" +
                    "[String]customerIdNumber：客户身份证号\n" +
                    "[String]customerPhoneNumber：客户手机号\n" +
                    "[String]customerPassword：客户密码\n" +
                    "[String]customerEmail：客户邮箱\n" +
                    "[String]customerAddress：客户地址\n" +
                    "[String]customerSex：客户性别\n" +
                    "[String]customerOccupation：客户职业\n" +
                    "[Date]customerBirthday：客户生日\n" +
                    "[Date]customerRegisterDay: 客户注册日\n" +
                    "[String]customerBankCard：客户绑定的银行卡\n" +
                    "[String]bankCardPassword：银行卡支付密码\n" +
                    "[String]customerBirthdayFormat：客户生日格式化日期\n" +
                    "[String]customerRegisterDayFormat：客户注册日格式化日期\n" +
                    "[BigDecimal]balance：余额\n"

            ),
    })
    @RequestMapping(value = "/getcustomerbyphonenumber/{phoneNumber}",method = RequestMethod.GET)
    public Customer getCustomerByPhoneNumber(@PathVariable String phoneNumber) {
        return customerService.getCustomerByPhoneNumber(phoneNumber);
    }

    @ApiOperation(value = "获取我的资料里的账号、注册年龄、已购产品数量", notes = "前端需传递请求后缀带上手机号码，例如customer/getCustomerByPhoneNumber/15858223459")
    @ApiResponses({
            @ApiResponse(code = 200, message = "关键字获取\n" +
                    "[String]customerPhoneNumber：客户手机号\n" +
                    "[String]registerTime：注册年龄\n" +
                    "[int]purchasedProductNum：已购产品数量\n"
            ),
    })
    @RequestMapping(value = "/getmyinfo/{customerPhoneNumber}",method = RequestMethod.POST)
    public MyInfoVo getMyInfo(@PathVariable String customerPhoneNumber){
        return customerService.getMyInfoByPhoneNumber(customerPhoneNumber);
    }

    @ApiOperation(value = "根据用户手机号及活动批次编号生成订单", notes = "前端需传递请求后缀带上手机号码和活动批次编号，例如customer/getCustomerByPhoneNumber/15858223459,1001")
    @ApiResponses({
            @ApiResponse(code = 200, message = "关键字获取\n" +
                    "[int]customerId：客户编号\n" +
                    "[int]activityId：活动批次编号\n" +
                    "[int]productId：产品编号\n" +
                    "[bigint]productPrice:产品价格\n" +
                    "[double]estimatedEarnings:预估收益\n" +
                    "[datetime]generateDate:下单时间\n" +
                    "[datetime]startDate:开始时间\n" +
                    "[datetime]endDate:结束时间\n"
            ),
    })
    @RequestMapping(value = "/secondsKill/{activityId},{phoneNumber}",method = RequestMethod.GET)
    public void secondsKill(@PathVariable Integer activityId,@PathVariable String phoneNumber){
        customerService.secondsKill(activityId,phoneNumber);
    }
}
