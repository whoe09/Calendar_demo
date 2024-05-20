package com.full.calendar.open_calendar.server.dailyLog.dto;

import lombok.Getter;

@Getter
public class LogStatusDto {
    private final String key;
    private final String desc;

    private final String color;

    public LogStatusDto(String key, String desc, String color) {
        this.key = key;
        this.desc = desc;
        this.color = color;
    }

}
