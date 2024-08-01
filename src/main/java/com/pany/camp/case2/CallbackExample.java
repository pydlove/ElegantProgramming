package com.pany.camp.case2;

import com.pany.camp.case2.main.Example2Handler;
import com.pany.camp.case2.main.Example3Handler;
import com.pany.camp.case2.main.ExampleHandler;
import com.pany.camp.case2.main.GraceExampleHandler;

/**
 *
 * @description:  CallbackExample
 * @copyright: @copyright (c) 2022 
 * @company: aiocloud
 * @author: panyong
 * @version: 1.0.0 
 * @createTime: 2024-07-29 20:11
 */
public class CallbackExample {

    public static void main(String[] args) {

        // 我先大概说下需求背景：
        // 我需要做一个业务，类似于 pageHelper 干的那种，但是我代码中就没举例的很详细了，
        // 大致就是在代码的开头我有个标识，需要存储到 ThreadLocal 中，在业务操作某个地方会用到，
        // 并且在代码的 finally 块中我得将标识清除掉。
        // 很多同学的实现方式可能是如我下面 ExampleHandler、Example2Handler、Example3Handler 这种实现，
        // 这种实现的弊端很大，就是在复用度高的时候，我业务端始终需要自己去管理标识的生命周期，这个对业务的耦合太强了，
        // 那么如何面向对象优化的实现呢？参考我 GraceExampleHandler 中，利用 Callback 的方式巧妙的剥离了标识，
        // 让业务不需要去维护标识。
        new ExampleHandler().handle();
        new Example2Handler().handle();
        new Example3Handler().handle();

        new GraceExampleHandler().handle();
    }
}
