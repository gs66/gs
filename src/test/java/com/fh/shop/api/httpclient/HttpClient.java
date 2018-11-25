package com.fh.shop.api.httpclient;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

public class HttpClient {
    @Test
    public void setHttpClient(){
        //打开浏览器
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //Url
        HttpGet httpGet=new HttpGet("https://blog.csdn.net/KK_bluebule/article/details/79157404");
        CloseableHttpResponse execute=null;
        try {
            execute = httpClient.execute(httpGet);
            String string = EntityUtils.toString(execute.getEntity(), "utf-8");
            FileWriter fileWriter = new FileWriter("D:/html.html");
            //调用Write 方法写入数据
            fileWriter.write(string);
            //进行刷新，将数据直接写入到目的地中
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(execute!=null){
                try {
                    execute.close();
                    execute=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(null!=httpGet){
                httpGet.releaseConnection();
                httpGet=null;
            }
            if(null!=httpClient){
                try {
                    httpClient.close();
                    httpClient=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
