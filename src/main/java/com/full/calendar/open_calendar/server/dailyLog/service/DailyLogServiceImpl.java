package com.full.calendar.open_calendar.server.dailyLog.service;

import com.full.calendar.open_calendar.server.dailyLog.dto.DailyLogDto;
import com.full.calendar.open_calendar.server.dailyLog.entity.DailyLogInfoEntity;
import com.full.calendar.open_calendar.server.dailyLog.enums.LogStatus;
import com.full.calendar.open_calendar.server.dailyLog.repository.DailyLogBulkRepository;
import com.full.calendar.open_calendar.server.dailyLog.repository.DailyLogQdRepository;
import com.full.calendar.open_calendar.server.dailyLog.repository.DailyLogRepository;
import com.full.calendar.open_calendar.server.user.entity.UserInfoEntity;
import com.full.calendar.open_calendar.server.user.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DailyLogServiceImpl implements DailyLogService {

    private final DailyLogRepository dailyLogRepository;

    private final DailyLogQdRepository dailyLogQdRepository;

    private final UserInfoRepository userInfoRepository;

    private final DailyLogBulkRepository dailyLogBulkRepository;

    static Pattern pattern = Pattern.compile("(\\d{4}-\\d{2}-\\d{2})");
    @Override
    public int registerDailyLog(Map<String,Object> logRegData) {
        LocalDateTime[] dateTimes = dateParse((String) logRegData.get("dailyRegDate"));
        logRegData.remove("dailyRegDate");
        List<DailyLogInfoEntity> logInfoEntities = new ArrayList<>();
        Map<Long, UserInfoEntity> userMap = userInfoRepository.findAll().stream()
                .collect(Collectors.toMap(UserInfoEntity::getId, userInfoEntity -> userInfoEntity));
        LocalDateTime startInit = dateTimes[0];

        for (Map.Entry<String, Object> entry : logRegData.entrySet()) {
            // get LogStatus stepBy
            LogStatus logStatus = LogStatus.valueOf(entry.getKey());
            List<Long> idList = convertToListLong(entry.getValue());

            for(Long id : idList) {
                dateTimes[0] = startInit;
                while (dateTimes[0].compareTo(dateTimes[1])<=0) {
                    // register First Day Start >>
                    DailyLogInfoEntity dailyLogInfoEntity = DailyLogInfoEntity.builder()
                            .userInfoEntity(userMap.get(id))
                            .logStatus(logStatus)
                            .regDate(dateTimes[0])
                            .build();
                    logInfoEntities.add(dailyLogInfoEntity);
                    dateTimes[0] = dateTimes[0].plusDays(1);
                }
            }
        }
        dailyLogBulkRepository.saveAll(logInfoEntities);
        return logInfoEntities.size();
    }

    @Override
    public List<DailyLogDto.SearchInfo> getDailyLogs(LocalDateTime searchDateTime) {
        List<DailyLogDto.RowInfo> dailyLog = dailyLogQdRepository.getDailyLog(searchDateTime);
        List<DailyLogDto.SearchInfo> searchInfos = new ArrayList<>();
        for(DailyLogDto.RowInfo info : dailyLog) {
            DailyLogDto.SearchInfo searchInfo = new DailyLogDto.SearchInfo(info.getTitle(),info.getRegDate(),info.getRegDate(),info.getLogStatus().getDesc());
            searchInfos.add(searchInfo);
        }
        return searchInfos;
    }

    private LocalDateTime[] dateParse(String dateStr) {
        LocalDateTime[] dateTimes = new LocalDateTime[2];
        Matcher matcher = pattern.matcher(dateStr);
        if (matcher.find()) {
            dateTimes[0] = LocalDateTime.parse(matcher.group(1)+ "T00:00:00");
        }
        if (matcher.find()) {
            dateTimes[1] = LocalDateTime.parse(matcher.group(1)+ "T00:00:00");
        }
        return dateTimes;
    }


    private List<Long> convertToListLong(Object value) {
        if(value instanceof String) {
            return Collections.singletonList(Long.parseLong((String) value));
        } else {
           return ((List<String>) value).stream().map(Long::parseLong).toList();
        }
    }
}
