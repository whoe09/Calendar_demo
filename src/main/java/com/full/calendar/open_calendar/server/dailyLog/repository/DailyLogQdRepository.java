package com.full.calendar.open_calendar.server.dailyLog.repository;

import com.full.calendar.open_calendar.server.dailyLog.dto.DailyLogDto;
import com.full.calendar.open_calendar.server.dailyLog.entity.QDailyLogInfoEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.full.calendar.open_calendar.server.dailyLog.entity.QDailyLogInfoEntity.dailyLogInfoEntity;

@Repository
@RequiredArgsConstructor
public class DailyLogQdRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public List<DailyLogDto.RowInfo> getDailyLog(LocalDateTime searchDateTime) {

        List<Long> longList = jpaQueryFactory
                .select(dailyLogInfoEntity.id)
                .from(dailyLogInfoEntity)
                .where(
                        dailyLogInfoEntity.regDate.year().eq(searchDateTime.getYear())
                            .and(dailyLogInfoEntity.regDate.month().eq(searchDateTime.getMonthValue()))
                )
                .fetch();

        List<DailyLogDto.RowInfo> fetch = new ArrayList<>();
        if(!CollectionUtils.isEmpty(longList)) {
            fetch.addAll(jpaQueryFactory.select(Projections.fields(DailyLogDto.RowInfo.class,
                            dailyLogInfoEntity.userInfoEntity.userName.as("title"),
                            dailyLogInfoEntity.regDate,
                            dailyLogInfoEntity.logStatus))
                    .from(dailyLogInfoEntity)
                    .where(
                            dailyLogInfoEntity.regDate.year().eq(searchDateTime.getYear())
                                    .and(dailyLogInfoEntity.regDate.month().eq(searchDateTime.getMonthValue()))
                    )
                    .fetch()
            );
        }
        return fetch;


    }







}
