package com.pany.camp.example.case6;

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
public class ThreeNestedIfElseExample {

    public static void main(String[] args) {

        // 主题：如何用合理的封装优雅的化解三层以上的 if-else ？
        //
        // 首先我先说下需求：这一次我们需要做一个心跳检测的服务，大致步骤如下：
        // 1、是否开启心跳检测？
        // 2、从 redis 上获取搜索的节点，然后对获取的结果进行判断
        // 3、遍历所有节点，针对每个节点做心跳检测
        // 4、心跳检测分为两个检测方式：主观检测 + 客观检测
        //
        // 基于这个需求，分别看下面两种实现，在代码我有明确指明哪些层是可以使用封装来减少 if-else 嵌套的层数，
        // 并且通过封装让代码可读性更强。
        // 错误案例 ExampleHandler().handle()
        // 正确案例 GraceExampleHandler().handle()
        new ExampleHandler().handle();

        new GraceExampleHandler().handle();
    }
}
