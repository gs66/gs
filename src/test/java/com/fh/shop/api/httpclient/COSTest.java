package com.fh.shop.api.httpclient;


import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import org.junit.Test;

import javax.swing.plaf.synth.Region;
import java.io.File;
import java.util.UUID;

public class COSTest {
    @Test
    public   void tesrCOS() {
        COSCredentials cred = new BasicCOSCredentials("AKIDiFYbP1aXR5TbT5SjljX8WloeLqCLtzVr", "FF3dx1rRmqgFZdRzylfMq43mFSP7ZllX");
        ClientConfig clientConfig = new ClientConfig(new com.qcloud.cos.region.Region("ap-beijing"));
        COSClient cosclient = new COSClient(cred, clientConfig);
        String bucketName = "gushuai-1257664018";
        File localFile = new File("C:/Users/Administrator/Desktop/face/640SG7WFUJI.jpg");
        String asdas  =UUID.randomUUID() + "";
        String key = asdas;
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        PutObjectResult putObjectResult = cosclient.putObject(putObjectRequest);


    }

}
