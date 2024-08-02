package com.pany.camp.example.case5;

import com.pany.camp.example.case4.main.ExampleHandler;
import com.pany.camp.example.case4.main.GraceExampleHandler;

/**
 *
 * @description:  ParamExample
 * @copyright: @copyright (c) 2022
 * @company: aiocloud
 * @author: panyong
 * @version: 1.0.0
 * @createTime: 2024-07-29 21:39
 */
public class IfElseExample {

    public static void main(String[] args) {

        // 主题：如何让两层 if-else 的代码更加优雅？
        //
        // 首先我说下需求：我需要在 redis 上管理每个主机的编号，主机编号是从 1 开始自增，
        // 并且有一个配置控制是否开启这种自动自增编号的，如果配置开启，就自增编号，
        // 如果配置没有开启，就使用默认的编号。
        // 针对这样一个需求，很多同学可以能都是使用 if-else 里面嵌套 if-else 来实现，
        // 就如 ExampleHandler().handle() 的写法，这种写法行数多且可读性差，
        // 我这里只是举例了一层，如果两层三层呢？两层以上的我会单独有个案例来演示。
        // 两层的 if-else，我们可以合理地使用三目运算符来优化，优雅的写法如: GraceExampleHandler().handle();
        new ExampleHandler().handle();

        new GraceExampleHandler().handle();
    }
}
