package com.fh.shop.api.httpclient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

public class HttpClient1 {
    @Test
    public void  http(){
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("https://www.huya.com/kaerlol");
        CloseableHttpResponse response=null;
        try {
            response= client.execute(httpGet);
            String string = EntityUtils.toString(response.getEntity(), "utf-8");
            FileWriter fileWriter = new FileWriter("D:/11.html");
            fileWriter.write(string);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(response!=null){
                try {
                    response.close();
                    response=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(httpGet!=null){
                httpGet.releaseConnection();
                httpGet=null;
            }
            if(client!=null){
                try {
                    client.close();
                    client=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
