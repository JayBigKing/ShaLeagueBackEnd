package com.example.shaleaguebackend.common;

import com.example.shaleaguebackend.common.utls.SessionUtils;

public class Judge {
    public static int judgeSession(){
        if(SessionUtils.session(false) == null ){
            //先判断是否有session或session是否过期
            return 300;
        }
        return 0;

    }
}
