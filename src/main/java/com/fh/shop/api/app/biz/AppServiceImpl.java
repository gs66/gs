package com.fh.shop.api.app.biz;

import com.fh.shop.api.app.mapper.IAppMapper;
import com.fh.shop.api.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("appService")
public class AppServiceImpl implements IAppService {
    @Autowired
    private IAppMapper appMapper;
    public String findSecret(String appKey) {
        String appSecret = RedisUtil.get("appKey");
        if (StringUtils.isNotEmpty(appSecret)) {
            return appSecret;
        }
        appSecret=appMapper.findSecret(appKey);
        if (StringUtils.isEmpty(appSecret)){
            return "";
        }
        return appSecret;
    }
}
