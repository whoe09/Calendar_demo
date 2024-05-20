package com.full.calendar.open_calendar.server.user.entity;

import com.full.calendar.open_calendar.global.support.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "USER_INFO")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserInfoEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_PK")
    private Long id;

    @Column(name = "USER_ID", unique = true, length = 50)
    @Comment("사용자 아이디")
    private String userId;

    @Column(name = "USER_PW", nullable = false, length = 100)
    @Comment("사용자 비밀번호")
    private String userPw;

    @Column(name = "USER_NAME", nullable = false, length = 100)
    @Comment("사용자 이름")
    private String userName;

    @Builder
    public UserInfoEntity(Long id, String userId, String userPw, String userName) {
        this.id = id;
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
    }
}
