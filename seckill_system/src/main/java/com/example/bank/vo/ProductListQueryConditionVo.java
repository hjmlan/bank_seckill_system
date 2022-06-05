package com.example.bank.vo;

public class ProductListQueryConditionVo {
    //当前页面
    private Integer curPage;
    //每页页面长度
    private Integer pageSize;
    //关键字
    private String keyWords;
    //起购金额
    private Long initialAmount;
    //产品期限
    private Long deadLine;
    //风险等级
    private String riskRating;
    //排序类型，七日年化收益率rateOfReturn，业绩比较基准rateOfComparative，起购金额initialAmount，有效期限deadLine
    private String selectType;
    //排序状态，0代表不排序，1代表升序，2代表降序
    private Integer state;


    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public Long getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(Long initialAmount) {
        this.initialAmount = initialAmount;
    }

    public Long getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Long deadLine) {
        this.deadLine = deadLine;
    }

    public String getRiskRating() {
        return riskRating;
    }

    public void setRiskRating(String riskRating) {
        this.riskRating = riskRating;
    }

    public String getSelectType() {
        return selectType;
    }

    public void setSelectType(String selectType) {
        this.selectType = selectType;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
