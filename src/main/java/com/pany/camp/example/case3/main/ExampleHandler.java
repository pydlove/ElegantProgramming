package com.pany.camp.example.case3.main;

import com.pany.camp.common.business.BusinessOperate;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description: ExampleHandler
 * @copyright: @copyright (c) 2022
 * @company: aiocloud
 * @author: panyong
 * @version: 1.0.0
 * @createTime: 2024-07-29 21:40
 */
public class ExampleHandler {

    /**
     * handle
     *
     * @since 1.0.0
     * @param
     * @return: void
     * @author: panyong
     * @version: 1.0.0
     * @createTime: 2024-07-29 21:46
     */
    public void handle(int code) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                8,
                8,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                r -> {
                    Thread thread = new Thread(r);
                    thread.setName("example-thread");
                    return thread;
                }
        );

        threadPoolExecutor.submit(() -> {
            BusinessOperate businessOperate = new BusinessOperate();
            businessOperate.execute(code);
        });
    }
}
