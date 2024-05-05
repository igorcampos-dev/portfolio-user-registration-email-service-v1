package com.ms.user.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Time {

    public static String getTime(){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
                .withZone(ZoneId.of("America/Sao_Paulo"))
                .format(Instant.now());
    }

}
