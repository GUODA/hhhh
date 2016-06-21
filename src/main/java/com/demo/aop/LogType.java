package com.demo.aop;

/**
 * @author xinxingegeya
 */
public enum LogType {

    ROLE_ADD("添加角色"),
    ROLE_UPDATE("更新角色"),
    ROLE_DELETE("删除角色"),

    USER_ADD("增加用户"),
    USER_UPDATE("更新用户"),
    USER_DELETE("删除用户"),

    ARTWORK_ADD("增加艺术品"),
    ARTWORK_UPDATE("更新艺术品"),
    ARTWORK_DELETE("删除艺术品"),

    ARTIST_ADD("添加艺术家"),
    ARTIST_UPDATE("更新艺术家"),
    ARTIST_DELETE("删除艺术家"),

    USER_LOGIN("用户登录");

    private final String value;

    private LogType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public String getValue() {
        return value;
    }
}
