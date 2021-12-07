package com.example.shaleaguebackend.model.MyTime;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class MyTimeHelp {
    private static final String FormatStr = "yyyy-MM-dd HH:mm:ss";
    private static final DateTimeFormatter df = DateTimeFormatter.ofPattern(FormatStr);

    public static LocalDateTime getNowDateTime(){
        return LocalDateTime.now();
    }

    public static String getNowDateTimeStr(){
        return df.format(LocalDateTime.now());
    }

    public static LocalDateTime  getStringToDateTime(String timeStr){
        return LocalDateTime.parse(timeStr,DateTimeFormatter.ofPattern(FormatStr));
    }

    public static String  getDateTimeToStr(LocalDateTime ldt){
        return df.format(ldt);
    }

    public static Map<String,Long> getDuration(LocalDateTime   startTime, LocalDateTime  endTime){
        //获取时间差
        Map<String,Long> map = new HashMap<>();
        java.time.Duration duration = java.time.Duration.between(startTime, endTime );
        map.put("Nanos",duration.toNanos());
        map.put("Mills",duration.toMillis());
        map.put("Minutes",duration.toMinutes());
        map.put("Hours",duration.toHours());
        map.put("Days",duration.toDays());
        return map;

    }
}
