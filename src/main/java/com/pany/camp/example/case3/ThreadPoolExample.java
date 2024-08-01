package com.pany.camp.example.case3;

import com.pany.camp.example.case3.main.ExampleHandler;
import com.pany.camp.example.case3.main.GraceExampleHandler;

/**
 *
 * @description:  ThreadPoolExample
 * @copyright: @copyright (c) 2022
 * @company: aiocloud
 * @author: panyong
 * @version: 1.0.0
 * @createTime: 2024-07-29 21:39
 */
public class ThreadPoolExample {

    public static void main(String[] args) {

        // 主题：线程池如何优雅的保护内存，如何优雅的统一管理？
        //
        // 首先说下背景需求：
        // 我需要并发处理某个业务，这个业务可能有点耗时，那么在业务数据量很大、服务器资源有限的情况如何去实现？
        // 我说下看到这个需求我的分析：
        // 1、并发处理，毋庸置疑肯定是使用线程池；
        // 2、业务数据量大且处理耗时，那么势必会引起阻塞队列积压，服务器资源有限的情况下，内存就成了瓶颈，可能会 OOM，那么就只能做保护措施，
        // 这里要有取舍，在保证不出错的情况下，只能做限流保护内存。至少能保证大部分成功，小选择部分失败或者重试。而不限流，一旦 OOM 那么就是大部分失败
        // 甚至不可用，这影响可能是 P0 级别的。
        //
        // 然后基于此类场景，我做了改进，改进的案例可以看 GraceExampleHandler().handle(), 通过封装 ThreadPoolFactory 和 ThreadPoolApp,
        // 实现了限流，除了限流，这还有多个好处，我们是不是系统中很多地方都用了线程池，但是如果没有一个集中管理的地方，那么后期维护这个线程池和排查问题非常困难，
        // 集中实现线程池管理，还可以做线程池的监控，实现了线程池的统一管理。
        for (int i = 0; i < 100000; i++) {
            new ExampleHandler().handle(i);
        }

        for (int i = 0; i < 100000; i++) {
            new GraceExampleHandler().handle(i);
        }
    }
}
