package com.fh.shop.api.sms.api;

import com.fh.shop.api.common.ServerResponce;
import com.fh.shop.api.sms.biz.ISMSService;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SMSController {

    @Resource
    private ISMSService SMSService;

    @RequestMapping(value = "/sms/sendSMS",method = RequestMethod.GET)
    public Object sendSMS(String mobile,String callback){
        ServerResponce code = SMSService.sendSMS(mobile);
        MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(code);
        mappingJacksonValue.setJsonpFunction(callback);
        return mappingJacksonValue;
    }
}
