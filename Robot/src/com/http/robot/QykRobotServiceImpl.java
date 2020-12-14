package com.http.robot;

import com.google.gson.Gson;

public class QykRobotServiceImpl implements RobotService{
    private  static  final String apiTpl = "http://api.qingyunke.com/api.php?key=free&appid=0&msg=%s";

    private static final Gson gson
            = new Gson();

    @Override
    public Response qa(String msg){
        String api = String.format(apiTpl, msg);
        System.out.println(api);
        String result = HttpUtils.request(api);
        Response response = gson.fromJson(result, Response.class);
        System.out.println(result);
        return  response;
    }
}