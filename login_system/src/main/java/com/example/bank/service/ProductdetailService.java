package com.example.bank.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bank.pojo.Productdetail;
import com.example.bank.vo.ProductInfoVo;
import com.example.bank.vo.ProductListQueryConditionVo;

import java.util.List;
import java.util.Map;

public interface ProductdetailService extends IService<Productdetail> {
    //获取活动当天的秒杀产品
    List<ProductInfoVo> getProductInActivity();
    //获取未来的秒杀产品
    List<ProductInfoVo> getFutureProduct();
    //根据产品编号加载产品详情
    ProductInfoVo getProductDetail(Integer activityId);
    //根据查询信息筛选产品列表
    Map<String,Object> getProductList(ProductListQueryConditionVo queryConditionVo);
}
