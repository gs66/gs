package com.fh.shop.api.util;

import com.fh.shop.api.app.biz.IAppService;
import com.fh.shop.api.common.ServerResponce;
import com.fh.shop.api.common.SystemEnum;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

public class securityApscet {

    @Resource(name="appService")
    private IAppService appService;

    private  static final  long ecpire=30*1000;
    public Object security(ProceedingJoinPoint pjp){
        HttpServletRequest request = WebContext.getRequest();
        System.out.println(request);
        String appkey = request.getHeader("appkey");
        String time=request.getHeader("time");
        String sign=request.getHeader("sign");
        String nonce = request.getHeader("nonce");
        //判断头信息是否丢失
        if (StringUtils.isEmpty(appkey)||StringUtils.isEmpty(time)||StringUtils.isEmpty(sign)){
            return ServerResponce.error(SystemEnum.HEADER_IS_MISS);
        }
        //判断是否过期
        long time1 = new Date().getTime();
        long parseLong = Long.parseLong(time);
        if (parseLong+ecpire<time1){
            return ServerResponce.error(SystemEnum.TIMEOUT);
        }
         //判断nonce
        Boolean setNx = RedisUtil.setNx(nonce, "1", 30);
        if (!setNx){
            return ServerResponce.error(SystemEnum.NONCE_IS_ERROR);
        }
        //查询appsecret
        String secret = appService.findSecret(appkey);
        if (StringUtils.isEmpty(secret)){
            return ServerResponce.error(SystemEnum.APPKEY_IS_ERROR);
        }
        //判断appkey是否正确
        String checkSum = CheckSumBuilder.getCheckSum(secret, nonce, time);
        if (!checkSum.equals(sign)){
            return ServerResponce.error(SystemEnum.SIGN_IS_ERROR);
        }
        //接口限流
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        if (method.isAnnotationPresent(Limit.class)){
            Limit annotation = method.getAnnotation(Limit.class);
            int maxCount = annotation.maxCount();
            int seconeds = annotation.seconeds();
            String key = appkey + request.getMethod() + request.getRequestURI();
            Long aLong = RedisUtil.incrExpire(key, seconeds);
            Integer integer = Integer.valueOf(String.valueOf(aLong));
            if (integer>maxCount){
                return ServerResponce.error(SystemEnum.RATE_LIMIT_ERROR);
            }
        }
        //调用接口
        Object proceed=null;
        try {
            proceed= pjp.proceed();
        } catch (Throwable throwable) {

            return ServerResponce.error();
        }
        return proceed;
    }

    public static void main(String[] args) {
        long time = new Date().getTime();
        String a="85bfb214-a4b1-4419-8370-c84a43015362";
    }
}
