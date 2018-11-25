package com.fh.shop.api.sms.biz;

import com.fh.shop.api.common.ServerResponce;
import com.fh.shop.api.common.SystemEnum;
import com.fh.shop.api.util.RedisUtil;
import com.fh.shop.api.util.SendSMS;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SMSServiceImpl implements ISMSService {

    public ServerResponce sendSMS(String mobile) {
        if(StringUtils.isEmpty(mobile)){
            return  ServerResponce.error(SystemEnum.MOBILE_MISS);
        }
        if (mobile.length()!=11){
            return ServerResponce.error(SystemEnum.MOBILE_INVALID);
        }
        String result = SendSMS.Sendsms(mobile);
        Gson gson = new Gson();
        Map map = gson.fromJson(result, Map.class);
        int code = ((Double) map.get("code")).intValue();
        String msg = (String) map.get("msg");
        String msgCode = (String) map.get("obj");
        if (code!=200){
             return ServerResponce.error(-1,"调用网易云短信接口错误信息:"+msg);
        }
        RedisUtil.set(mobile,msgCode);
        RedisUtil.expire(mobile);
        return ServerResponce.success();
    }
}
