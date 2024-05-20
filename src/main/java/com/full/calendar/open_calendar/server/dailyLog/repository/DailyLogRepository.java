package com.full.calendar.open_calendar.server.dailyLog.repository;

import com.full.calendar.open_calendar.server.dailyLog.entity.DailyLogInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyLogRepository extends JpaRepository<DailyLogInfoEntity,Long> {

}
