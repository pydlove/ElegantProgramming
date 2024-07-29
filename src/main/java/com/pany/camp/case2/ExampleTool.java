package com.pany.camp.case2;

/**
 *
 * @description: ExampleTool
 * @copyright: @copyright (c) 2022 
 * @company: aiocloud
 * @author: panyong
 * @version: 1.0.0 
 * @createTime: 2024-07-29 20:19
 */
public class ExampleTool {

    private static final ThreadLocal<Long> LOCAL = new ThreadLocal<>();

    public static void setFlag(Long flag) {
        LOCAL.set(flag);
    }

    public static Long getFlag() {
       return LOCAL.get();
    }

    public static void removeFlag() {
        LOCAL.remove();
    }
}
