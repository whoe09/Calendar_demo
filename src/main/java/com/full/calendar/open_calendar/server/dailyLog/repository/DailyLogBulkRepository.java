package com.full.calendar.open_calendar.server.dailyLog.repository;

import com.full.calendar.open_calendar.server.dailyLog.entity.DailyLogInfoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class DailyLogBulkRepository {

    private final JdbcTemplate jdbcTemplate;

    @Transactional
    public void saveAll(List<DailyLogInfoEntity> dailyLogs) {
        String sql = "INSERT INTO DAILY_LOG_INFO (USER_INFO_FK,DAILY_LOG_STATUS,DAILY_LOG_DATE,CREATE_DATE,UPDATE_DATE) " +
                "VALUE(?,?,?,?,?)";

        jdbcTemplate.batchUpdate(sql,
                dailyLogs,
                dailyLogs.size(),
                (PreparedStatement ps, DailyLogInfoEntity log) -> {
                    ps.setLong(1,log.getUserInfoEntity().getId());
                    ps.setString(2,log.getLogStatus().getKey());
                    ps.setTimestamp(3, Timestamp.valueOf(log.getRegDate()));
                    ps.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
                    ps.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
                });
    }
}
