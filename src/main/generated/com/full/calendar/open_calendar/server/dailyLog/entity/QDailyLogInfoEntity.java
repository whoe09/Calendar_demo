package com.full.calendar.open_calendar.server.dailyLog.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDailyLogInfoEntity is a Querydsl query type for DailyLogInfoEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDailyLogInfoEntity extends EntityPathBase<DailyLogInfoEntity> {

    private static final long serialVersionUID = -1803113642L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDailyLogInfoEntity dailyLogInfoEntity = new QDailyLogInfoEntity("dailyLogInfoEntity");

    public final com.full.calendar.open_calendar.global.support.entity.QBaseEntity _super = new com.full.calendar.open_calendar.global.support.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<com.full.calendar.open_calendar.server.dailyLog.enums.LogStatus> logStatus = createEnum("logStatus", com.full.calendar.open_calendar.server.dailyLog.enums.LogStatus.class);

    public final DateTimePath<java.time.LocalDateTime> regDate = createDateTime("regDate", java.time.LocalDateTime.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDate = _super.updateDate;

    public final com.full.calendar.open_calendar.server.user.entity.QUserInfoEntity userInfoEntity;

    public QDailyLogInfoEntity(String variable) {
        this(DailyLogInfoEntity.class, forVariable(variable), INITS);
    }

    public QDailyLogInfoEntity(Path<? extends DailyLogInfoEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDailyLogInfoEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDailyLogInfoEntity(PathMetadata metadata, PathInits inits) {
        this(DailyLogInfoEntity.class, metadata, inits);
    }

    public QDailyLogInfoEntity(Class<? extends DailyLogInfoEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userInfoEntity = inits.isInitialized("userInfoEntity") ? new com.full.calendar.open_calendar.server.user.entity.QUserInfoEntity(forProperty("userInfoEntity")) : null;
    }

}

