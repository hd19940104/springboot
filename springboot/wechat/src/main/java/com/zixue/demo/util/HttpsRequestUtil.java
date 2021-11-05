package com.zixue.demo.util;
import com.zixue.demo.config.MyX509TrustManager;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.URL;

/**
 * @Description: HTTPS请求工具
 */
public class HttpsRequestUtil {


    /**
     * 发送get请求
     * @param href 请求的url
     * @return
     */
    public static String doGet(String href) {
        //建立连接
        URL url;
        HttpsURLConnection httpUrlConn=null;
        InputStream inputStream=null;
        BufferedReader bufferedReader=null;
        InputStreamReader inputStreamReader=null;
        try {
            url = new URL(href);
            httpUrlConn = (HttpsURLConnection) url.openConnection();

            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = { new MyX509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            httpUrlConn.setSSLSocketFactory(ssf);
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod("GET");
            // 取得输入流
            inputStream = httpUrlConn.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            //读取响应内容
            StringBuffer buffer = new StringBuffer();
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 释放资源
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            httpUrlConn.disconnect();
        }
        return null;
    }

    /**
     * 发送post请求
     * @param href 请求的url
     * @param json 请求的参数（json格式）
     * @return
     */
    public static String doPost(String href,String json){
        URL url;
        HttpsURLConnection httpUrlConn=null;
        InputStream inputStream=null;
        BufferedReader bufferedReader=null;
        InputStreamReader inputStreamReader=null;
        try {
            url = new URL(href);
            httpUrlConn = (HttpsURLConnection) url.openConnection();

            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = { new MyX509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            httpUrlConn.setSSLSocketFactory(ssf);
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);

            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod("POST");

            //将menu数据作为请求参数
            OutputStream outputStream = httpUrlConn.getOutputStream();
            // 注意编码格式，防止中文乱码
            outputStream.write(json.getBytes("UTF-8"));
            outputStream.close();

            // 取得输入流
            inputStream = httpUrlConn.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            //读取响应内容
            StringBuffer buffer = new StringBuffer();
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 释放资源
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            httpUrlConn.disconnect();
        }
        return null;
    }

}
