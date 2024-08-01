package com.pany.camp.example.case5.main;

import com.pany.camp.common.business.BusinessOperate;
import com.pany.camp.common.redis.RedisKey;
import com.pany.camp.common.redis.RedisNameSpace;
import com.pany.camp.common.redis.RedisOperate;

import java.util.Objects;

/**
 *
 * @description: ExampleHandler
 * @copyright: @copyright (c) 2022 
 * @company: aiocloud
 * @author: panyong
 * @version: 1.0.0 
 * @createTime: 2024-08-01 19:19
 */
public class ExampleHandler {

    private final boolean isOpenAutoRegister;

    private static final int DEFAULT_NO = 1;

    public ExampleHandler() {
        this.isOpenAutoRegister = initParam();
    }

    private boolean initParam() {
        return false;
    }

    /**
     * handle
     * 
     * @since 1.0.0
     * @param
     * @return: void 
     * @author: panyong 
     * @version: 1.0.0 
     * @createTime: 2024-08-01 19:20 
     */  
    public void handle() {

        // 此案例主要看 getHostNo 的逻辑，这个应该是大部分同学会这样写的
        int hostNo = getHostNo();

        // 拿到主机号后，基于主机号做的业务操作（这块可以忽略不看，只是单纯为了让案例好看一点）
        BusinessOperate businessOperate = new BusinessOperate();
        businessOperate.execute(hostNo);
    }

    /**
     * getHostNo
     * 
     * @since 1.0.0
     * @param
     * @return: int 
     * @author: panyong 
     * @version: 1.0.0 
     * @createTime: 2024-08-01 19:58 
     */  
    private int getHostNo() {

        String hostName = "localhost";
        RedisKey hostNoKey = new RedisKey(RedisNameSpace.SYSTEM_HOST_NO, hostName);
        Object hostNo = RedisOperate.get(hostNoKey);

        // 主要看这段代码，可以思考一下这种情况如何让可读性更强
        if (Objects.isNull(hostNo)) {

            if (!isOpenAutoRegister) {

                return DEFAULT_NO;
            } else {

                // 这里是注册主机的编号，由于案例请忽略分布式线程安全问题
                return registerHostNo(hostNoKey);
            }

        } else {

            return Integer.parseInt(String.valueOf(hostNo));
        }
    }

    /**
     * registerHostNo
     * 
     * @since 1.0.0
     * @param 
     * @param hostNoKey
     * @return: int 
     * @author: panyong 
     * @version: 1.0.0 
     * @createTime: 2024-08-01 19:55 
     */  
    private int registerHostNo(RedisKey hostNoKey) {

        RedisKey horizontalNoKey = new RedisKey(RedisNameSpace.SYSTEM_HOST_HORIZONTAL_NO);
        Object horizontalNoObj = RedisOperate.get(horizontalNoKey);
        int horizontalNo = Objects.isNull(horizontalNoObj) ? DEFAULT_NO : Integer.parseInt(String.valueOf(horizontalNoObj));

        int hostNo = horizontalNo + 1;
        RedisOperate.set(hostNoKey, hostNo);
        RedisOperate.set(horizontalNoKey, horizontalNo);

        return hostNo;
    }

}
