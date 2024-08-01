package com.pany.camp.case1;

import com.pany.camp.case1.main.ExampleHandler;
import com.pany.camp.case1.main.GraceExampleHandler;

/**
 *
 * @description: ExceptionExample
 * @copyright: @copyright (c) 2022 
 * @company: aiocloud
 * @author: panyong
 * @version: 1.0.0 
 * @createTime: 2024-07-29 9:18
 */
public class ExceptionExample {

    public static void main(String[] args) {

        // 我们看 ExampleHandler 中的 handle 方法，它捕获了很多自定义异常，针对这些异常，如果都和我示例的这样编写的话，
        // 代码整体很影响阅读，为了能够优雅美观且面向对象，我决定对它进行修改，修改的实例请看 GraceExampleHandler。
        ExampleHandler exampleHandler = new ExampleHandler();
        exampleHandler.handle();

        GraceExampleHandler graceExampleHandler = new GraceExampleHandler();
        graceExampleHandler.handle();
    }
}
