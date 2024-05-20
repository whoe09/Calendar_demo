package com.full.calendar.open_calendar.server.user.service;

import com.full.calendar.open_calendar.server.user.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto.SimpleInfo> getUserList();

}
