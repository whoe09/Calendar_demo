package com.full.calendar.open_calendar.server.dailyLog.entity;

import com.full.calendar.open_calendar.global.support.entity.BaseEntity;
import com.full.calendar.open_calendar.server.dailyLog.enums.LogStatus;
import com.full.calendar.open_calendar.server.user.entity.UserInfoEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Entity
@Table(name = "DAILY_LOG_INFO")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class DailyLogInfoEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DAILY_LONG_PK")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_INFO_FK", nullable = false)
    @Comment("사용자 정보 외래키")
    private UserInfoEntity userInfoEntity;

    @Column(name = "DAILY_LOG_STATUS",nullable = false)
    @Enumerated(EnumType.STRING)
    private LogStatus logStatus;

    @Column(name = "DAILY_LOG_DATE",nullable = false)
    private LocalDateTime regDate;

    @Builder
    public DailyLogInfoEntity(Long id, UserInfoEntity userInfoEntity, LogStatus logStatus, LocalDateTime regDate) {
        this.id = id;
        this.userInfoEntity = userInfoEntity;
        this.logStatus = logStatus;
        this.regDate = regDate;
    }
}
