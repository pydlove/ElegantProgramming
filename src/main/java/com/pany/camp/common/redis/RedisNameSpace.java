package com.pany.camp.common.redis;

/**
 * @description: RedisNameSpace
 * @copyright: @copyright (c) 2022
 * @company: aiocloud
 * @author: panyong
 * @version: 1.0.0
 * @createTime: 2024-08-01 19:24
 */
public enum RedisNameSpace {

    SYSTEM_HOST_NO("system:host:no"),
    SYSTEM_HOST_HORIZONTAL_NO("system:host:horizontal:no"),
    SYSTEM_HEARTBEAT_HOST("system:heartbeat:host"),
    SYSTEM_HEARTBEAT_TIME("system:heartbeat:time");

    private final String nameSpace;

    RedisNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }

    public String getNameSpace() {
        return nameSpace;
    }
}
`