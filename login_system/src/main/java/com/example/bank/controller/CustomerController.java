package com.example.bank.controller;

import com.example.bank.pojo.Customer;
import com.example.bank.pojo.Key;
import com.example.bank.service.CustomerService;
import com.example.bank.service.Impl.SecondsKillServiceImpl;
import com.example.bank.service.SecondsKillService;
import com.example.bank.vo.MyInfoVo;
import com.example.bank.vo.SecKillVo;
import io.swagger.annotations.*;
import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Api(tags = "用户接口")
@Controller
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    SecondsKillService secondsKillService;
    @Autowired
    RedisTemplate redisTemplate;


    @PostMapping("/queryAll")
    @ApiOperation("查询所有客户")
    @ResponseBody
    @ApiResponses({
            @ApiResponse(code=200,message = "查询成功"),
            @ApiResponse(code=400,message = "查询失败")
    })
    public List<Customer> query(){return customerService.queryAll();}

    @RequestMapping("/login")
    @ApiOperation(value = "用户手机号密码登录",notes="前端传递参数用JSON传参")
    @ApiResponses({
            @ApiResponse(code=200,message = "登录成功"),
            @ApiResponse(code=400,message = "用户名或密码错误")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name="customerPhoneNumber",value="客户手机号",required=true,paramType="query"),
            @ApiImplicitParam(name="customerPassword",value="客户密码",required=true,paramType="query")}
    )
    public String login(){
        return "Login";
    }


    @GetMapping("/loginresult")
    public String loginresult(HttpServletRequest req, HttpServletResponse resp){
        String customerPhoneNumber = req.getParameter("phonenumber");
        String customerPassword = req.getParameter("password");
        Customer customer = new Customer();
        customer.setCustomerPhoneNumber(customerPhoneNumber);
        customer.setCustomerPassword(customerPassword);
        System.out.println("测试成功");
        boolean flag = customerService.login(customer);
        if(flag==true){
            System.out.println("success");
            return "loginsuccess";
        }else{
            System.out.println("fail");
            return "loginfail";
        }
    }



    @GetMapping("/enroll")
    public String enroll(){
        return "enroll";
    }

    @GetMapping("/enrollresult")
    public String enrollresult(HttpServletRequest req, HttpServletResponse resp){
        String customerPhoneNumber = req.getParameter("customerPhoneNumber");
        String customerPassword = req.getParameter("customerPassword");
        String customerIdNumber = req.getParameter("customerIdNumber");
        String customerName = req.getParameter("customerName");
        String customerEmail = req.getParameter("customerEmail");

        Customer customer = new Customer();
        customer.setCustomerPhoneNumber(customerPhoneNumber);
        customer.setCustomerName(customerName);
        customer.setCustomerIdNumber(customerIdNumber);
        customer.setCustomerEmail(customerEmail);
        customer.setCustomerPassword(customerPassword);

        System.out.println("测试成功2");
        boolean flag = customerService.enroll(customer);
        if(flag==true){
            System.out.println("success");
            return "enrollsuccess";
        }else{
            System.out.println("fail");
            return "enrollfail";
        }
    }

    @GetMapping("/loginsuccess")
    public String success(){
        return "loginsuccess";
    }

    @GetMapping("/loginfail")
    public String fail(){
        return "loginfail";
    }

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
    @ResponseBody
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
    @RequestMapping(value = "/secondsKill/{activityId},{phoneNumber},{verifyHash}",method = RequestMethod.GET)
    public void secondsKill(@PathVariable Integer activityId,@PathVariable String phoneNumber,@PathVariable String verifyHash){
        customerService.secondsKill(activityId,phoneNumber,verifyHash);
    }

    @RequestMapping(value="/getHash/{activityId},{phoneNumber}",method = RequestMethod.GET)
    @ResponseBody
    public String getVerifyHash(@PathVariable Integer activityId,@PathVariable String phoneNumber){
        return secondsKillService.getVerifyHash(activityId,phoneNumber);
    }
    @RequestMapping(value ="/secondsKill/createOrder/{activityId},{phoneNumber},{verifyHash}",method = RequestMethod.GET)
    @ResponseBody
    public void createOrder(@PathVariable Integer activityId,@PathVariable String phoneNumber,@PathVariable String verifyHash) throws Exception {
        String hashKey = Key.verifyKey.getKey() + "_" + phoneNumber + "_" + activityId;
        String verifyHashInRedis = (String) redisTemplate.opsForValue().get(hashKey);
        System.out.println("缓存校验码为:"+ verifyHashInRedis);
        System.out.println("输入校验码为:"+ verifyHash);
//        if (secondsKillService.check(phoneNumber,activityId,verifyHash)){
//            customerService.secondsKill(activityId,phoneNumber);
        if(verifyHash.equals(verifyHashInRedis)){
            customerService.secondsKill(activityId,phoneNumber,verifyHash);
        }
        else{
            throw new RuntimeException("抢购失败,请重试");
        }
    }
}
