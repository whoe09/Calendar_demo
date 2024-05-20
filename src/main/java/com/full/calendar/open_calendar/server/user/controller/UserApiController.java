package com.full.calendar.open_calendar.server.user.controller;

import com.full.calendar.open_calendar.global.support.response.ApiResponse;
import com.full.calendar.open_calendar.server.user.dto.UserDto;
import com.full.calendar.open_calendar.server.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user")
public class UserApiController {

    private final UserService userService;

    @GetMapping("")
    public ApiResponse<List<UserDto.SimpleInfo>> getUserList() {
        return ApiResponse.success(userService.getUserList());
    }


}
