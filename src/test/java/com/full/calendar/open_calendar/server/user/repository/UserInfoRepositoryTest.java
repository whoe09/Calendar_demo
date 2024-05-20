package com.full.calendar.open_calendar.server.user.repository;

import com.full.calendar.open_calendar.server.user.entity.UserInfoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoRepositoryTest {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Test
    void 유저_생성() {
        //given
        List<UserInfoEntity> userInfoEntities = new ArrayList<>();

        //when
        for (int i = 0; i < 10; i++) {
            UserInfoEntity userInfoEntity = UserInfoEntity.builder()
                    .userId("newUser"+i)
                    .userPw("1234")
                    .userName("신규"+i+"유저")
                    .build();
            userInfoEntities.add(userInfoEntity);
        }
        userInfoRepository.saveAll(userInfoEntities);
        //then

    }

}