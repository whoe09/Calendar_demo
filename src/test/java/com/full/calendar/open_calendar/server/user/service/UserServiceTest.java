package com.full.calendar.open_calendar.server.user.service;

import com.full.calendar.open_calendar.server.user.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void 유저목록테스트() {
        //given

        //when
        List<UserDto.SimpleInfo> userList = userService.getUserList();

        //then
        System.out.println(userList.size());
    }
}