package com.full.calendar.open_calendar.server.user.repository;

import com.full.calendar.open_calendar.server.user.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfoEntity,Long> {

}
