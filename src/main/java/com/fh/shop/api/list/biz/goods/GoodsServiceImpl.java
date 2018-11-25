package com.fh.shop.api.list.biz.goods;

import com.fh.shop.api.common.ServerResponce;
import com.fh.shop.api.list.mapper.goods.IGoodsMapper;
import com.fh.shop.api.list.po.goods.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements IGoodsService {
    @Autowired
    private IGoodsMapper goodsMapper;


    public ServerResponce goodsList() {
        List<Goods> goodsList = goodsMapper.goodsList();
        return ServerResponce.success(goodsList);
    }
}
