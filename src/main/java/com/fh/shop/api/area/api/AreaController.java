package com.fh.shop.api.area.api;

import com.fh.shop.api.area.biz.IAreaService;
import com.fh.shop.api.common.ServerResponce;
import com.fh.shop.api.util.Limit;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AreaController {

    @Resource
    private IAreaService areaService;

    @RequestMapping(value = "/area/findAreaListbyId",method = RequestMethod.GET)
    @Limit(seconeds = 30,maxCount = 3)
    public Object findAreaListbyId(int id,String callback){
        ServerResponce areaList =areaService.findAreaListbyId(id);
        MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(areaList);
        mappingJacksonValue.setJsonpFunction(callback);
        return mappingJacksonValue;
    }
}
