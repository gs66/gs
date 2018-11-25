package com.fh.shop.api.util;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpClient {
    public static String sendSMS(String url, Map<String,String> params,Map<String,String> headers) throws UnsupportedEncodingException {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);
        if (null!=params&&params.size()!=0) {
            List<NameValuePair> pairs = new ArrayList<NameValuePair>();
            Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> next = iterator.next();
                String key = next.getKey();
                String value = next.getValue();
                pairs.add(new BasicNameValuePair(key, value));
            }
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(pairs, "utf-8");
            httpPost.setEntity(urlEncodedFormEntity);
        }
        if (headers!=null&&headers.size()!=0) {
            Iterator<Map.Entry<String, String>> iterator1 = headers.entrySet().iterator();
            while (iterator1.hasNext()) {
                Map.Entry<String, String> next = iterator1.next();
                String key = next.getKey();
                String value = next.getValue();
                httpPost.addHeader(key, value);
            }
        }
        CloseableHttpResponse response=null;
        String result="";
        try {
            response= client.execute(httpPost);
            result= EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null!=response){
                try {
                    response.close();
                    response=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null!=httpPost){
                httpPost.releaseConnection();
            }
            if (null!=client){
                try {
                    client.close();
                    client=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        return result;
    }
}
