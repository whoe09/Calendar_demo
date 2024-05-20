package com.full.calendar.open_calendar.server.dailyLog.service;

import com.full.calendar.open_calendar.server.dailyLog.dto.DailyLogDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface DailyLogService {

    int registerDailyLog(Map<String,Object> logRegData);

    List<DailyLogDto.SearchInfo> getDailyLogs(LocalDateTime searchDateTime);

}
