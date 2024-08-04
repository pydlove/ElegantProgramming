package com.pany.camp.example.case6.main;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.TypeReference;
import com.pany.camp.common.redis.RedisKey;
import com.pany.camp.common.redis.RedisNameSpace;
import com.pany.camp.common.redis.RedisOperate;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;

/**
 *
 * @description:  ExampleHandler
 * @copyright: @copyright (c) 2022 
 * @company: aiocloud
 * @author: panyong
 * @version: 1.0.0 
 * @createTime: 2024-08-03 16:56
 */
@Slf4j
public class ExampleHandler {

    private static final long HEARTBEAT_TIMEOUT = 1000 * 60 * 5;

    public void handle() {

        // 假设我们这里要做心跳检测服务
        if (isOpenHeartbeatCheck()) {

            // 首先获取所有节点
            Object hostObj = RedisOperate.get(new RedisKey(RedisNameSpace.SYSTEM_HEARTBEAT_HOST));
            if (Objects.isNull(hostObj)) {
                log.error("system heartbeat host not existed, please check in redis");
                return;
            }

            // 遍历节点检查心跳
            List<String> hostNames = JSONObject.parseObject(hostObj.toString(), new TypeReference<List<String>>() {});
            for (String hostName : hostNames) {

                // 主观检查：如果没有查看到注册心跳，证明可能下线了
                Object hostTimeObj = RedisOperate.get(new RedisKey(RedisNameSpace.SYSTEM_HEARTBEAT_TIME, hostName));
                if (Objects.isNull(hostTimeObj)) {
                    log.error("system heartbeat time, host: {} not report time for redis", hostName);

                    // 客观判断：如果心跳超时了，那么我们在请求下节点的接口，根据接口是否响应，来判断节点是否还存活
                    if (!requestNodeAlive(hostName)) {

                        // 确认节点下线了，做一些善后的处理，如：故障转移，通知其他节点，通知用户等
                        AftermathHandler.handle(hostName);
                    }

                } else {

                    // 主观检查：首先基于时间戳判断，是否上报的心跳超时了
                    long hostTime = Long.parseLong(hostTimeObj.toString());
                    if (System.currentTimeMillis() - hostTime > HEARTBEAT_TIMEOUT) {

                        // 客观判断：如果心跳超时了，那么我们在请求下节点的接口，根据接口是否响应，来判断节点是否还存活
                        if (!requestNodeAlive(hostName)) {

                            // 确认节点下线了，做一些善后的处理，如：故障转移，通知其他节点，通知用户等
                            AftermathHandler.handle(hostName);
                        }
                    }
                }
            }
        }
    }

    private boolean requestNodeAlive(String hostName) {
        return httpRequestByHostName(hostName);
    }

    private boolean httpRequestByHostName(String hostName) {

        // 假设这里是通过 http 请求来判断节点是否还存活
        return false;
    }

    private boolean isOpenHeartbeatCheck() {

        // 假设这里是从环境配置中读取是否开启心跳检测
        return getFromApplicationConfig();
    }

    private Boolean getFromApplicationConfig() {
        return true;
    }
}
