package com.http.robot;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {
    public static  String request(String api){
        HttpURLConnection connection = null;
        int responseCode = 0;
        String result = null;
        try {
            URL url = new URL(api);
            //获取对应的连接对象
            connection = (HttpURLConnection)url.openConnection();

            responseCode = connection.getResponseCode();
        }catch (IOException e){
            e.printStackTrace();
        }

        if (200 <= responseCode && responseCode <= 299){
            try (InputStream inputStream = connection.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream))){
                StringBuilder response = new StringBuilder();
                String currentLine;
                while ((currentLine = in.readLine()) != null) {
                    response.append(currentLine);
                }
                result = response.toString();
                return result;
            }catch(Exception e){
                e.printStackTrace();
            }
            }
        System.out.println("responseCode" + responseCode);
            return result;
        }
    }

