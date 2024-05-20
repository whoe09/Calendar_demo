package com.full.calendar.open_calendar.server.dailyLog.controller;

import com.full.calendar.open_calendar.global.support.response.ApiResponse;
import com.full.calendar.open_calendar.server.dailyLog.dto.DailyLogDto;
import com.full.calendar.open_calendar.server.dailyLog.dto.LogStatusDto;
import com.full.calendar.open_calendar.server.dailyLog.enums.LogStatus;
import com.full.calendar.open_calendar.server.dailyLog.service.DailyLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/daily")
public class DailyLogApiController {

    private final DailyLogService dailyLogService;


    @PostMapping("")
    public ApiResponse<Integer> dailyLogAdd(@RequestBody Map<String,Object> logRegData) {
        return ApiResponse.success(dailyLogService.registerDailyLog(logRegData));
    }

    @GetMapping("")
    public ApiResponse<List<DailyLogDto.SearchInfo>> test(@RequestParam("searchDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime searchDate) {
        return ApiResponse.success(dailyLogService.getDailyLogs(searchDate));
    }

    @GetMapping("/log/status")
    public ApiResponse<List<LogStatusDto>> getLogStatus() {
        return ApiResponse.success(LogStatus.getAllLogStatus());
    }
}
