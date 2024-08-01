package com.pany.camp.common.redis;

import lombok.Getter;

/**
 *
 * @description: RedisKey
 * @copyright: @copyright (c) 2022 
 * @company: aiocloud
 * @author: panyong
 * @version: 1.0.0 
 * @createTime: 2024-08-01 19:29
 */
public class RedisKey {

    @Getter
    private final String key;

    public RedisKey(RedisNameSpace redisNameSpace, Object suffix) {
        this.key = redisNameSpace.getNameSpace() + ":" + suffix;
    }

    public RedisKey(RedisNameSpace redisNameSpace) {
        this.key = redisNameSpace.getNameSpace();
    }
}
