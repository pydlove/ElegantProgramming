package com.pany.camp.example.case5.main;

import com.pany.camp.common.business.BusinessOperate;
import com.pany.camp.common.redis.RedisKey;
import com.pany.camp.common.redis.RedisNameSpace;
import com.pany.camp.common.redis.RedisOperate;

import java.util.Objects;

/**
 * @description: GraceExampleHandler
 * @copyright: @copyright (c) 2022
 * @company: aiocloud
 * @author: panyong
 * @version: 1.0.0
 * @createTime: 2024-08-01 20:02
 */
public class GraceExampleHandler {

    private final boolean isOpenAutoRegister;

    private static final int DEFAULT_NO = 1;

    public GraceExampleHandler() {
        this.isOpenAutoRegister = initParam();
    }

    private boolean initParam() {
        return false;
    }

    /**
     * handle
     *
     * @param
     * @return: void
     * @author: panyong
     * @version: 1.0.0
     * @createTime: 2024-08-01 19:20
     * @since 1.0.0
     */
    public void handle() {

        // 此案例主要看 getHostNo 的逻辑，这个是优化后的程序
        int hostNo = getHostNo();

        // 拿到主机号后，基于主机号做的业务操作（这块可以忽略不看，只是单纯为了让案例好看一点）
        BusinessOperate businessOperate = new BusinessOperate();
        businessOperate.execute(hostNo);
    }

    /**
     * getHostNo
     *
     * @param
     * @return: int
     * @author: panyong
     * @version: 1.0.0
     * @createTime: 2024-08-01 19:58
     * @since 1.0.0
     */
    private int getHostNo() {

        String hostName = "localhost";
        RedisKey hostNoKey = new RedisKey(RedisNameSpace.SYSTEM_HOST_NO, hostName);
        Object hostNo = RedisOperate.get(hostNoKey);

        // 主要看这段代码，下面的写法更加优雅，仅用了三行代码
        if (Objects.nonNull(hostNo)) {
            return Integer.parseInt(String.valueOf(hostNo));
        }

        return isOpenAutoRegister ? registerHostNo(hostNoKey) : DEFAULT_NO;
    }

    /**
     * registerHostNo
     *
     * @param
     * @param hostNoKey
     * @return: int
     * @author: panyong
     * @version: 1.0.0
     * @createTime: 2024-08-01 19:55
     * @since 1.0.0
     */
    private int registerHostNo(RedisKey hostNoKey) {

        // 这里是注册主机的编号，由于案例请忽略分布式线程安全问题
        RedisKey horizontalNoKey = new RedisKey(RedisNameSpace.SYSTEM_HOST_HORIZONTAL_NO);
        Object horizontalNoObj = RedisOperate.get(horizontalNoKey);
        int horizontalNo = Objects.isNull(horizontalNoObj) ? DEFAULT_NO : Integer.parseInt(String.valueOf(horizontalNoObj));

        int hostNo = horizontalNo + 1;
        RedisOperate.set(hostNoKey, hostNo);
        RedisOperate.set(horizontalNoKey, horizontalNo);

        return hostNo;
    }
}
