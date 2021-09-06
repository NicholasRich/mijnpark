package com.boyang.landsense.common.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 503989629L;

    public static final QUser user = new QUser("user");

    public final BooleanPath accountNonExpired = createBoolean("accountNonExpired");

    public final BooleanPath accountNonLocked = createBoolean("accountNonLocked");

    public final CollectionPath<org.springframework.security.core.GrantedAuthority, org.springframework.security.core.QGrantedAuthority> authorities = this.<org.springframework.security.core.GrantedAuthority, org.springframework.security.core.QGrantedAuthority>createCollection("authorities", org.springframework.security.core.GrantedAuthority.class, org.springframework.security.core.QGrantedAuthority.class, PathInits.DIRECT2);

    public final BooleanPath credentialsNonExpired = createBoolean("credentialsNonExpired");

    public final BooleanPath enabled = createBoolean("enabled");

    public final StringPath id = createString("id");

    public final StringPath password = createString("password");

    public final StringPath username = createString("username");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

