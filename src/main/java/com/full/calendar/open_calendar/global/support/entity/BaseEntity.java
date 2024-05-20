package com.full.calendar.open_calendar.global.support.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @CreatedDate
    @Column(name = "CREATE_DATE", nullable = false)
    @Comment("생성일자")
    private LocalDateTime createDate;

    @CreatedDate
    @Column(name = "UPDATE_DATE", nullable = false)
    @Comment("수정일자")
    private LocalDateTime updateDate;



}
