package com.example.bank.controller;

import com.example.bank.service.ProductdetailService;
import com.example.bank.vo.ProductInfoVo;
import com.example.bank.vo.ProductListQueryConditionVo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "产品信息接口")
@RestController
@CrossOrigin
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductdetailService productdetailService;

    @ApiOperation(value = "进入主界面，加载此时间段秒杀产品预览", notes = "不需要传入JSON，调用接口即可\n传回来需要自行判断该产品是几点的秒杀\n时间格式: yyyy-MM-dd HH:mm:ss")
    @ApiResponses({
            @ApiResponse(code = 200, message = "关键字获取\n" +
                    "[int]productId：产品编号\n" +
                    "[int]activityId：批次编号\n" +
                    "[String]Name：产品名\n" +
                    "[String]salesChannels：销售渠道\n" +
                    "[Long]initialAmount: 起购金额\n" +
                    "[long]deadLine：产品期限\n" +
                    "[double]rateOfReturn：七日年化收益率\n" +
                    "[double]rateOfComparative：业绩比较基准\n" +
                    "[String]activityStartTime：秒杀起始时间\n" +
                    "[String]activityEndTime：秒杀结束时间\n" +
                    "[long]remainAmount：余量\n" +
                    "[long]totalAmount：总量\n" +
                    "[Date]activityStartTimeFormat：秒杀起始时间格式转化\n" +
                    "[Date]activityEndTimeFormat：秒杀结束时间格式转化\n"
            ),
    })
    @RequestMapping(value = "/getproductinactivity",method = RequestMethod.POST)
    public List<ProductInfoVo> getProductInActivity(){
        return productdetailService.getProductInActivity();
    }


    @ApiOperation(value = "进入主界面，加载未来秒杀产品预览", notes = "不需要传入JSON，调用接口即可\n传回来需要自行判断该产品是几点的秒杀\n时间格式: yyyy-MM-dd HH:mm:ss")
    @ApiResponses({
            @ApiResponse(code = 200, message = "关键字获取\n" +
                    "[int]productId：产品编号\n" +
                    "[int]activityId：批次编号\n" +
                    "[String]Name：产品名\n" +
                    "[Long]initialAmount: 起购金额\n" +
                    "[long]deadLine：产品期限\n" +
                    "[double]rateOfReturn：七日年化收益率\n" +
                    "[double]rateOfComparative：业绩比较基准\n" +
                    "[String]activityStartTime：秒杀起始时间\n" +
                    "[String]activityEndTime：秒杀结束时间\n" +
                    "[Date]activityStartTimeFormat：秒杀起始时间格式转化\n" +
                    "[Date]activityEndTimeFormat：秒杀结束时间格式转化\n"
            ),
    })
    @RequestMapping(value = "/getfutureproduct",method = RequestMethod.POST)
    public List<ProductInfoVo> getFutureProduct(){
        return productdetailService.getFutureProduct();
    }

    @ApiOperation(value = "加载产品详情", notes = "前端需传递请求后缀带上批次编号，例如product/getProductDetail/1001")
//    @ApiImplicitParam(name = "req",value = "id：***")
    @ApiResponses({
            @ApiResponse(code = 200, message = "关键字获取\n" +
                    "[int]productId：产品编号\n" +
                    "[int]activityId：批次编号\n" +
                    "[String]Name：产品名\n" +
                    "[String]salesChannels：销售渠道\n" +
                    "[Long]initialAmount: 起购金额\n" +
                    "[long]deadLine：产品期限\n" +
                    "[double]rateOfReturn：七日年化收益率\n" +
                    "[double]rateOfComparative：业绩比较基准\n" +
                    "[Date]activityStartTime：秒杀起始时间\n" +
                    "[Date]activityEndTime：秒杀结束时间\n" +
                    "[long]remainAmount：余量\n" +
                    "[long]totalAmount：总量\n" +
                    "[String]riskRating：风险评估\n" +
                    "[int]purchaseEachOf：每人限购\n" +
                    "[Date]activityStartTimeFormat：秒杀起始时间格式转化\n" +
                    "[Date]activityEndTimeFormat：秒杀结束时间格式转化\n"
            ),
    })
    @RequestMapping(value = "/getproductdetail/{activityId}",method = RequestMethod.POST)
    public ProductInfoVo getProductDetail(@PathVariable Integer activityId){
        ProductInfoVo res = productdetailService.getProductDetail(activityId);
        return res;
    }

    @ApiOperation(value = "获取产品列表", notes =  "需要传递JSON数据,包括\n" +
            "keyWords: 关键词\n" +
            "initialAmount: 起购金额[没选择返回-1]\n" +
            "deadLine: 产品期限[没选择返回-1]\n" +
            "riskRating: 风险等级\n" +
            "selectType: 排序类型，七日年化收益率rateOfReturn，业绩比较基准rateOfComparative，起购金额initialAmount，有效期限deadLine\n" +
            "state: 排序状态，0代表不排序，1代表升序，2代表降序\n" +
            "curPage: 当前页数\n" +
            "pageSize: 当前页面显示多少页\n")
    @ApiResponses({
            @ApiResponse(code = 200, message = "关键字获取\n" +
                    "[int]id：产品编号\n" +
                    "[String]name：产品名\n" +
                    "[String]salesChannels：销售渠道\n" +
                    "[Long]initialAmount: 起购金额\n" +
                    "[long]deadLine：产品期限\n" +
                    "[double]rateOfReturn：七日年化收益率\n" +
                    "[double]rateOfComparative：业绩比较基准\n" +
                    "[String]riskRating：风险等级\n"

            ),
    })
    @RequestMapping(value = "/getproductlist",method = RequestMethod.POST)
    public Map<String,Object> getProductList(@RequestBody ProductListQueryConditionVo productListQueryConditionVo){
        return productdetailService.getProductList(productListQueryConditionVo);
    }
}
