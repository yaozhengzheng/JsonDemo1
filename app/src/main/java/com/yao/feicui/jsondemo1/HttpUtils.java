package com.yao.feicui.jsondemo1;

import android.util.Log;

import java.io.ByteArrayOutputStream ;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 16245 on 2016/05/25.
 */
public class HttpUtils {

    private static String sStringInputStream;

    public HttpUtils() {
    }

    public static String getJsonContent(String path) {
        try {
            URL url=new URL(path);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
//            connection.setConnectTimeout(7000);
//            connection.setRequestMethod("GET");
//            connection.setDoInput(true);
//            int code=connection.getResponseCode();
//            if (code==200){
            Log.d("######","djfjfjfjf");
                sStringInputStream = changeInputStream(connection.getInputStream());
//            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sStringInputStream;
    }

    /**
     * 将输入流转换成指定编码的字符串
     * @param inputStream
     * @return
     */
    private static String changeInputStream(InputStream inputStream) {
        String jsonString="";
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        int len=0;
        byte[]date=new byte[1024];
        try {
            Log.d("######","1111111111111111");
            while((len=inputStream.read(date))!=-1){
                outputStream.write(date,0,len);
                Log.d("######","222222222222");
            }
            jsonString=new String(outputStream.toByteArray());

            System.out.println(outputStream.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
