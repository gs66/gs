package com.fh.shop.api.util;

import org.apache.commons.lang.RandomStringUtils;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SendSMS {
    public static  String Sendsms(String mobile)  {
        String url=SystemConst.URL;
        Map params=new HashMap();
        params.put("mobile",mobile);
        params.put("templateid",SystemConst.TEMPLATEID);
        params.put("codeLen",SystemConst.CODELEN);

        HashMap headers = new HashMap();
        headers.put("AppKey",SystemConst.APPKEY);
        String nonce = RandomStringUtils.randomAlphabetic(8);
        headers.put("Nonce",nonce);
        String curTime = new Date().getTime() + "";
        headers.put("CurTime",curTime);
        headers.put("CheckSum",CheckSumBuilder.getCheckSum(SystemConst.APPSECRET,nonce,curTime));

        String sendSMS = null;
        try {
            sendSMS = HttpClient.sendSMS(url, params, headers);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sendSMS;
    }
}
