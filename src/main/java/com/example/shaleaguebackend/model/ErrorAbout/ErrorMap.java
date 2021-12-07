package com.example.shaleaguebackend.model.ErrorAbout;

import java.util.HashMap;
import java.util.Map;

public class ErrorMap {
    private static final Map<String,Integer> errorStrMapCode = new HashMap<String,Integer>(){{
        put("账号或密码错误",550);
        put("回答错误",551);
        put("没有Session",552);
        put("没有这个文件",4041);
        put("没有这个id",4042);
    }};

    public static int getErrorCode(String str){
        return errorStrMapCode.get(str);
    }

}
