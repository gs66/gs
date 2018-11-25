package com.fh.shop.api.list.api;


import com.fh.shop.api.list.biz.goods.IGoodsService;
import com.fh.shop.api.common.ServerResponce;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class GoodsApi {

    @Resource
    private IGoodsService goodsService;

    @RequestMapping(value = "/goods/list",method = RequestMethod.GET)
    public Object goodsList(String callback)
    {
        ServerResponce goodsList = goodsService.goodsList();
        MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(goodsList);
        mappingJacksonValue.setJsonpFunction(callback);
        return mappingJacksonValue;
    }
}
