package com.pany.camp.common.redis;

/**
 *
 * @description:  RedisOperate
 * @copyright: @copyright (c) 2022 
 * @company: aiocloud
 * @author: panyong
 * @version: 1.0.0 
 * @createTime: 2024-08-01 19:31
 */
public class RedisOperate {

    public static Object get(RedisKey redisKey) {

        // 假设这里是从 redis 上获取数据
        return getFromRedis(redisKey);
    }

    public static void set(RedisKey hostNoKey, Object value) {

        // 假设这里是 set key-value 到 redis 上
        set2Redis(hostNoKey, value);
    }

    private static void set2Redis(RedisKey hostNoKey, Object value) {
    }

    private static Object getFromRedis(RedisKey redisKey) {
        return null;
    }
}
