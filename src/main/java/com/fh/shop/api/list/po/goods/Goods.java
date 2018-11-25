package com.fh.shop.api.list.po.goods;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Goods  implements Serializable {
    private static final long serialVersionUID = 7173929599296927064L;

    private Integer id;

    private String goodsName;

    private String goodsPhoto;

    private BigDecimal goodsPrice;

    private Integer goodsCount;

    private BigDecimal minGoodsPrice;

    private BigDecimal maxGoodsPrice;

    private Integer minGoodsCount;

    private Integer maxGoodsCount;


    private Integer brandId;

    private List<Integer> idList=new ArrayList();

    private Integer category1;

    private Integer category2;

    private Integer category3;

    private String categoryInfo;

    public BigDecimal getMinGoodsPrice() {
        return minGoodsPrice;
    }

    public void setMinGoodsPrice(BigDecimal minGoodsPrice) {
        this.minGoodsPrice = minGoodsPrice;
    }

    public BigDecimal getMaxGoodsPrice() {
        return maxGoodsPrice;
    }

    public void setMaxGoodsPrice(BigDecimal maxGoodsPrice) {
        this.maxGoodsPrice = maxGoodsPrice;
    }

    public String getCategoryInfo() {
        return categoryInfo;
    }

    public void setCategoryInfo(String categoryInfo) {
        this.categoryInfo = categoryInfo;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsPhoto() {
        return goodsPhoto;
    }

    public void setGoodsPhoto(String goodsPhoto) {
        this.goodsPhoto = goodsPhoto;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Integer getMinGoodsCount() {
        return minGoodsCount;
    }

    public void setMinGoodsCount(Integer minGoodsCount) {
        this.minGoodsCount = minGoodsCount;
    }

    public Integer getMaxGoodsCount() {
        return maxGoodsCount;
    }

    public void setMaxGoodsCount(Integer maxGoodsCount) {
        this.maxGoodsCount = maxGoodsCount;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }

    public Integer getCategory1() {
        return category1;
    }

    public void setCategory1(Integer category1) {
        this.category1 = category1;
    }

    public Integer getCategory2() {
        return category2;
    }

    public void setCategory2(Integer category2) {
        this.category2 = category2;
    }

    public Integer getCategory3() {
        return category3;
    }

    public void setCategory3(Integer category3) {
        this.category3 = category3;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPhoto='" + goodsPhoto + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsCount=" + goodsCount +
                ", minGoodsPrice=" + minGoodsPrice +
                ", maxGoodsPrice=" + maxGoodsPrice +
                ", minGoodsCount=" + minGoodsCount +
                ", maxGoodsCount=" + maxGoodsCount +
                ", brandId=" + brandId +
                ", idList=" + idList +
                ", category1=" + category1 +
                ", category2=" + category2 +
                ", category3=" + category3 +
                ", categoryInfo='" + categoryInfo + '\'' +
                '}';
    }
}
