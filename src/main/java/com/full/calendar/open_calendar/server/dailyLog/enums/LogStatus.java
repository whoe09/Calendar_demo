package com.full.calendar.open_calendar.server.dailyLog.enums;

import com.full.calendar.open_calendar.server.dailyLog.dto.LogStatusDto;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum LogStatus {
    LIST_A("LIST_A","주간근무","green"),
    LIST_B("LIST_B","야간근무","black"),
    LIST_C("LIST_C","주말근무(토)","blue"),
    LIST_D("LIST_D","주말근무(일)","orange"),
    LIST_E("LIST_E","비번","pink"),
    LIST_F("LIST_F","연차","yellow"),
    LIST_G("LIST_G","오전반차","red"),
    LIST_H("LIST_H","오후반차","blue");

    private final String key;
    private final String desc;
    private final String color;

    LogStatus(String key, String desc, String color) {
        this.key = key;
        this.desc = desc;
        this.color = color;
    }
    public static List<LogStatusDto> getAllLogStatus() {
        List<LogStatusDto> logStatusDtos = new ArrayList<>();
        for(LogStatus logStatus : values()) {
            logStatusDtos.add(new LogStatusDto(logStatus.key,logStatus.desc,logStatus.color));
        }
        return logStatusDtos;
    }
}
