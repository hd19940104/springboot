package com.zixue.demo.robot.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @Author: Yun
 * @Description:
 * @Date: Created in 2017-11-30 9:49
 */
public class HttpRequestUtil {

    private static Logger logger= LoggerFactory.getLogger(HttpRequestUtil.class);

    /**
     * post请求（用于请求json格式的参数）
     * @param url
     * @param params
     * @return
     */
    public static String doPost(String url, String params,String charset){

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);// 创建httpPost
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-Type", "application/json");
        StringEntity entity = new StringEntity(params, charset);
        httpPost.setEntity(entity);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpPost);
            StatusLine status = response.getStatusLine();
            int state = status.getStatusCode();
            if (state == HttpStatus.SC_OK) {
                HttpEntity responseEntity = response.getEntity();
                String jsonString = EntityUtils.toString(responseEntity,charset);
                return jsonString;
            }
            else{
                logger.error("请求发生错误,返回:"+state+"("+url+")");
            }
        }catch (Exception e){
            logger.error("请求出现异常:"+e.getClass().getName());
        }
        finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * get请求
     * @param url   url
     * @return
     */
    public static String doGet(String url,String charset){
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        String result = null;
        HttpGet httpGet = null;
        try {
            httpClient = HttpClientBuilder.create().build();
            httpGet = new HttpGet(url);
            httpResponse = httpClient.execute(httpGet);
            result = EntityUtils.toString(httpResponse.getEntity(), charset);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpGet != null) {
                httpGet.releaseConnection();
            }
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }



    public static void main(String[] args) throws Exception {
        String json="{\"key\":\"b736254463ac4036b2373850884502a7\",\"info\":\"你好\",\"userid\":\"dsy123456\"}";
        String url="http://www.tuling123.com/openapi/api";
        System.out.println(HttpRequestUtil.doPost(url,json,"utf-8"));
    }

}

