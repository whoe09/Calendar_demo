package com.full.calendar.open_calendar.server.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserInfoEntity is a Querydsl query type for UserInfoEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserInfoEntity extends EntityPathBase<UserInfoEntity> {

    private static final long serialVersionUID = -2133867498L;

    public static final QUserInfoEntity userInfoEntity = new QUserInfoEntity("userInfoEntity");

    public final com.full.calendar.open_calendar.global.support.entity.QBaseEntity _super = new com.full.calendar.open_calendar.global.support.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDate = _super.updateDate;

    public final StringPath userId = createString("userId");

    public final StringPath userName = createString("userName");

    public final StringPath userPw = createString("userPw");

    public QUserInfoEntity(String variable) {
        super(UserInfoEntity.class, forVariable(variable));
    }

    public QUserInfoEntity(Path<? extends UserInfoEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserInfoEntity(PathMetadata metadata) {
        super(UserInfoEntity.class, metadata);
    }

}

