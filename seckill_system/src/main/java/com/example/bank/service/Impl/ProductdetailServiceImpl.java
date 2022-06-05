package com.example.bank.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bank.mapper.ActivityMapper;
import com.example.bank.mapper.ProductdetailMapper;
import com.example.bank.pojo.Activity;
import com.example.bank.pojo.Productdetail;
import com.example.bank.service.ProductdetailService;
import com.example.bank.vo.ProductInfoVo;
import com.example.bank.vo.ProductListQueryConditionVo;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ProductdetailServiceImpl extends ServiceImpl<ProductdetailMapper, Productdetail> implements ProductdetailService {

    @Autowired
    private ProductdetailMapper productdetailMapper;
    @Autowired
    private ActivityMapper activityMapper;

    //列出活动当天的秒杀产品
    @Override
    public List<ProductInfoVo> getProductInActivity() {
        QueryWrapper<Activity> activityQueryWrapper = new QueryWrapper<>();

        SimpleDateFormat sfm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String curDate = sfm.format(new Date());
        //根据现在时间找到活动时间内的所有产品
        activityQueryWrapper.select("*").le("startDate",curDate).ge("endDate",curDate);
        List<Activity> activityList = activityMapper.selectList(activityQueryWrapper);
        List<Productdetail> productdetailList = new ArrayList<>();
        //查找出所有活动后，根据每个活动里的productID找出productdetail
        for (Activity activity:activityList) {
            QueryWrapper<Productdetail> productdetailQueryWrapper = new QueryWrapper<>();
            //sql语句
            productdetailQueryWrapper.select("*").eq("id",activity.getProductId());
            //新建实体
            Productdetail productdetail = new Productdetail();
            //取数据
            productdetail = productdetailMapper.selectOne(productdetailQueryWrapper);
            //加到List里
            productdetailList.add(productdetail);
        }

        List<ProductInfoVo> res = new ArrayList<>();
        for (int i = 0; i < activityList.size(); i ++){
            ProductInfoVo productInfoVo = new ProductInfoVo(productdetailList.get(i),activityList.get(i));
            res.add(productInfoVo);
        }

        return res;
    }

    //列出未来的秒杀产品
    @Override
    public List<ProductInfoVo> getFutureProduct() {
        QueryWrapper<Activity> activityQueryWrapper = new QueryWrapper<>();
        SimpleDateFormat sfm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String curDate = sfm.format(new Date());
        //根据现在时间找到未来
        activityQueryWrapper.select("*").ge("startDate",curDate).orderByDesc("endDate");
        List<Activity> activityList = activityMapper.selectList(activityQueryWrapper);
        List<Productdetail> productdetailList = new ArrayList<>();
        //查找出所有活动后，根据每个活动里的productID找出productdetail
        for (Activity activity:activityList) {
            QueryWrapper<Productdetail> productdetailQueryWrapper = new QueryWrapper<>();
            //sql语句
            productdetailQueryWrapper.select("*").eq("id",activity.getProductId());
            //新建实体
            Productdetail productdetail = new Productdetail();
            //取数据
            productdetail = productdetailMapper.selectOne(productdetailQueryWrapper);
            //加到List里
            productdetailList.add(productdetail);
        }

        List<ProductInfoVo> res = new ArrayList<>();
        for (int i = 0; i < activityList.size(); i ++){
            ProductInfoVo productInfoVo = new ProductInfoVo(productdetailList.get(i),activityList.get(i));
            res.add(productInfoVo);
        }
        return res;
    }

    //根据产品编号加载产品详情
    @Override
    public ProductInfoVo getProductDetail(Integer activityId) {
        QueryWrapper<Activity> activityQueryWrapper = new QueryWrapper<>();
        QueryWrapper<Productdetail> productdetailQueryWrapper =new QueryWrapper<>();
        //根据批次id找批次信息以及产品id
        activityQueryWrapper.select("*").eq("id",activityId);
        Activity activity = activityMapper.selectOne(activityQueryWrapper);
        productdetailQueryWrapper.select("*").eq("id",activity.getProductId());
        Productdetail productdetail = productdetailMapper.selectOne(productdetailQueryWrapper);
        ProductInfoVo res = new ProductInfoVo(productdetail,activity);
        return res;
    }

    @Override
    public Map<String, Object> getProductList(ProductListQueryConditionVo queryConditionVo) {
        //mybatis-plus的分页插件，先确定页数、每页显示多少条
        Page pageInfo = new Page(queryConditionVo.getCurPage(),queryConditionVo.getPageSize());
        //查询条件
        QueryWrapper<Productdetail> productdetailQueryWrapper = new QueryWrapper<>();
        productdetailQueryWrapper.select("*");
        if (!StringUtil.isNullOrEmpty(queryConditionVo.getKeyWords())) {
            productdetailQueryWrapper.like("name",queryConditionVo.getKeyWords());
        }
        if (queryConditionVo.getInitialAmount() > 0) {
            productdetailQueryWrapper.ge("initialAmount",queryConditionVo.getInitialAmount());
        }
        if (queryConditionVo.getDeadLine() > 0) {
            productdetailQueryWrapper.eq("deadLine",queryConditionVo.getDeadLine());
        }
        if (!StringUtil.isNullOrEmpty(queryConditionVo.getRiskRating())) {
            productdetailQueryWrapper.eq("riskRating",queryConditionVo.getRiskRating());
        }
        if (!StringUtil.isNullOrEmpty(queryConditionVo.getSelectType())) {
            if (queryConditionVo.getState() == 1) {
                productdetailQueryWrapper.orderByAsc(queryConditionVo.getSelectType());
            }
            else if (queryConditionVo.getState() == 2) {
                productdetailQueryWrapper.orderByDesc(queryConditionVo.getSelectType());
            }

        }
        IPage<Productdetail> iPage = productdetailMapper.selectPage(pageInfo,productdetailQueryWrapper);
        Map<String,Object> pageMap = new HashMap<>();
        pageMap.put("totalRecords",iPage.getTotal());
        pageMap.put("totalPages",iPage.getPages());
        pageMap.put("data",iPage.getRecords());
        return pageMap;
    }

}
