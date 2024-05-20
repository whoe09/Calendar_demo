package com.full.calendar.open_calendar.server.user.service;

import com.full.calendar.open_calendar.server.user.dto.UserDto;
import com.full.calendar.open_calendar.server.user.entity.UserInfoEntity;
import com.full.calendar.open_calendar.server.user.repository.UserInfoRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserInfoRepository userInfoRepository;

    @Override
    public List<UserDto.SimpleInfo> getUserList() {
        return userInfoRepository.findAll().stream().map(UserDto.SimpleInfo::toDto).toList();
    }
}
