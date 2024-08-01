package com.pany.camp.case3.main;

import lombok.extern.slf4j.Slf4j;

/**
 * @description: GraceExampleHandler
 * @copyright: @copyright (c) 2022
 * @company: aiocloud
 * @author: panyong
 * @version: 1.0.0
 * @createTime: 2024-07-29 21:40
 */
@Slf4j
public class GraceExampleHandler {

    /**
     * handle
     *
     * @param
     * @return: void
     * @author: panyong
     * @version: 1.0.0
     * @createTime: 2024-07-29 21:46
     * @since 1.0.0
     */
    public void handle(int code) {

        String threadName = "example-thread";

        try {
            ThreadPoolFactory.register(threadName, 8, true, 500L);
            ThreadPoolFactory.submit(threadName, () -> {
                BusinessOperate businessOperate = new BusinessOperate();
                businessOperate.execute(code);
            });

        } catch (Exception ex) {
            log.error("grace example handle error, threadName: {}, caused by:", threadName, ex);
        }
    }
}
