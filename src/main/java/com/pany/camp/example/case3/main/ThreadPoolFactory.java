package com.pany.camp.example.case3.main;

import com.pany.camp.common.exception.RegisteredException;
import com.pany.camp.common.exception.UnRegisterException;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @description: ThreadPoolFactory
 * @copyright: @copyright (c) 2022
 * @company: aiocloud
 * @author: panyong
 * @version: 1.0.0
 * @createTime: 2024-07-30 15:02
 */
@Slf4j
public class ThreadPoolFactory {

    private static final Map<String, ThreadPoolApp> THREAD_CONTAINER = new ConcurrentHashMap<>();

    private static final AtomicInteger COUNT = new AtomicInteger(0);

    /**
     * register
     *
     * @since 1.0.0
     * @param
     * @param threadName
     * @param coreThread
     * @return: void
     * @author: panyong
     * @version: 1.0.0
     * @createTime: 2024-07-30 15:02
     */
    public static void register(String threadName, int coreThread) throws RegisteredException {
        register(threadName, coreThread, false, null);
    }

    /**
     * register
     *
     * @since 1.0.0
     * @param
     * @param threadName
     * @param coreThread
     * @param openLimit
     * @param limitSize
     * @return: void
     * @author: panyong
     * @version: 1.0.0
     * @createTime: 2024-07-30 15:02
     */
    public static void register(String threadName, int coreThread, boolean openLimit, Long limitSize) throws RegisteredException {

        if (THREAD_CONTAINER.containsKey(threadName)) {
            log.error("this thread ({}) registered, not register twice", threadName);
            throw new RegisteredException(threadName + " registered");
        }

        ThreadPoolExecutor threadPoolExecutor = initThreadPoolExecutor(threadName, coreThread);
        ThreadPoolApp threadPoolApp = new ThreadPoolApp();
        threadPoolApp.setThreadPoolExecutor(threadPoolExecutor);
        threadPoolApp.setThreadName(threadName);
        threadPoolApp.setOpenLimit(openLimit);
        threadPoolApp.setLimitSize(limitSize);
        threadPoolApp.setLimitTime(1000L);

        THREAD_CONTAINER.put(threadName, threadPoolApp);
    }

    /**
     * submit
     *
     * @since 1.0.0
     * @param
     * @param threadName
     * @param task
     * @return: void
     * @author: panyong
     * @version: 1.0.0
     * @createTime: 2024-08-01 9:11
     */
    public static void submit(String threadName, Runnable task) throws UnRegisterException {

        if (!THREAD_CONTAINER.containsKey(threadName)) {
            log.error("this thread ({}) unregister, please check", threadName);
            throw new UnRegisterException(threadName + " unregister");
        }

        ThreadPoolApp threadPoolApp = THREAD_CONTAINER.get(threadName);
        threadPoolApp.submit(task);
    }

    /**
     * initThreadPoolExecutor
     *
     * @since 1.0.0
     * @param
     * @param threadName
     * @param coreThread
     * @return: java.util.concurrent.ThreadPoolExecutor
     * @author: panyong
     * @version: 1.0.0
     * @createTime: 2024-07-30 15:18
     */
    private static ThreadPoolExecutor initThreadPoolExecutor(String threadName, int coreThread) {

        ThreadFactory threadFactory = r -> {
            Thread thread = new Thread(r);
            thread.setName(threadName + "-" + COUNT.addAndGet(1));
            return thread;
        };

        return new ThreadPoolExecutor(
                coreThread,
                coreThread,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                threadFactory
        );
    }
}
