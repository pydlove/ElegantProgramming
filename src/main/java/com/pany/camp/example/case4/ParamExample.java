package com.pany.camp.example.case4;

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
public class ParamExample {

    public static void main(String[] args) {

        // 主题：用返回代替传参会更加优雅
        //
        // 我这举一个简单的例子，ExampleHandler().handle() 这就是一个反例，
        // 我需要查询出系统里所有的用户名和所有用户对应的角色，
        // 这个例子举的可能不那么严谨，我们可以先不去关注它的合理性。
        // 在这个需求的前提下，因为我要返回两个集合类 userNames 和 roleNameMap，
        // 由于方法只能返回一个类型，那么很多同学就会和我这个例子中的方式一样，在方法调用的外面创建两个集合，
        // 然后作为参数传入到方法里面，然后在里面对这两个集合进行业务处理，
        // 这里有两个问题：
        // 1、方法名称不见名知意，getxxx 的方法一般是有返回值的，如果是这个传集合然后返回该集合的场景，用这种方式处理，
        // 方法名称也应该是 handlexxx 或者 replenishxxx，大概得意思就是处理这些集合或者补充、完善这些集合；
        // 2、这样在 getUserAndRoleNames 隐形去操作这两个集合，这对调试、定位问题和读者都是不友好的。
        // 对于这种情况，更加优雅的处理请看 GraceExampleHandler.handle();
        new ExampleHandler().handle();

        new GraceExampleHandler().handle();
    }
}
