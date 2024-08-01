package com.pany.camp.example.case3.main;

import cn.hutool.core.thread.ThreadUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @description: ThreadPoolApp
 * @copyright: @copyright (c) 2022
 * @company: aiocloud
 * @author: panyong
 * @version: 1.0.0
 * @createTime: 2024-07-30 15:01
 */
@Slf4j
@Data
public class ThreadPoolApp {

    private ThreadPoolExecutor threadPoolExecutor;

    private String threadName;

    private Boolean openLimit;

    private Long limitSize;

    private Long limitTime;

    public void submit(Runnable task) {
        limitOperate();
        threadPoolExecutor.submit(task);
    }

    /**
     * 限流操作
     *
     * @since 1.0.0
     * @param
     * @return: void
     * @author: panyong
     * @version: 1.0.0
     * @createTime: 2024-08-01 9:44
     */
    public void limitOperate() {

        if (openLimit) {
            int size = threadPoolExecutor.getQueue().size();
            while (size > limitSize) {

                log.warn("thread: {} exceed threshold: {}, waill wait {} ms", threadName, limitSize, limitTime);
                ThreadUtil.sleep(limitTime);
                size = threadPoolExecutor.getQueue().size();
            }
        }
    }

}
