package com.fh.shop.api.sms.biz;

import com.fh.shop.api.common.ServerResponce;

public interface ISMSService {
    ServerResponce sendSMS(String mobile);
}
