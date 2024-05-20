package com.full.calendar.open_calendar.server.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.full.calendar.open_calendar.server.user.entity.UserInfoEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDto {

    @Getter
    @NoArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public static class SimpleInfo {
        private Long id;

        private String userId;

        private String userName;

        @Builder
        public SimpleInfo(Long id, String userId, String userName) {
            this.id = id;
            this.userId = userId;
            this.userName = userName;
        }

        public static SimpleInfo  toDto(UserInfoEntity userInfoEntity) {
            return SimpleInfo.builder()
                    .id(userInfoEntity.getId())
                    .userId(userInfoEntity.getUserId())
                    .userName(userInfoEntity.getUserName())
                    .build();
        }
    }



}

