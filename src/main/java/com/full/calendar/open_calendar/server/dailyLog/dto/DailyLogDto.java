package com.full.calendar.open_calendar.server.dailyLog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.full.calendar.open_calendar.server.dailyLog.enums.LogStatus;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DailyLogDto {

    @Getter
    @NoArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public static class Info {
        private Long id;
        private List<Long> userId;

//        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDate startDate;

//        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDate endDate;

        @Builder
        public Info(Long id, List<Long> userId, LocalDate startDate, LocalDate endDate) {
            this.id = id;
            this.userId = userId;
            this.startDate = startDate;
            this.endDate = endDate;
        }
    }

    @Getter
    @NoArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public static class CreatInfo {

        private LogStatus logStatus;
        private Long userId;

//        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        private LocalDateTime regDate;

        @Builder
        public CreatInfo(LogStatus logStatus, Long userId, LocalDateTime startDate) {
            this.logStatus = logStatus;
            this.userId = userId;
            this.regDate = regDate;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class RowInfo {
        private String title;
        private LocalDateTime regDate;
        private LogStatus logStatus;

        @Builder
        public RowInfo(String title, LocalDateTime regDate, LogStatus logStatus) {
            this.title = title;
            this.regDate = regDate;
            this.logStatus = logStatus;
        }
    }
    @Getter
    @NoArgsConstructor
    public static class SearchInfo {
        private String title;
        private LocalDateTime startDate;
        private LocalDateTime endDate;

        private String logStatus;

        public SearchInfo(String title, LocalDateTime startDate, LocalDateTime endDate,String logStatus) {
            this.title = title;
            this.startDate = startDate;
            this.endDate = endDate;
            this.logStatus = logStatus;
        }
    }
}
