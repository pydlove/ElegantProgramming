package com.pany.camp.case2.main;

import com.pany.camp.case2.main.Callback;

/**
 *
 * @description: GraceExampleTool
 * @copyright: @copyright (c) 2022 
 * @company: aiocloud
 * @author: panyong
 * @version: 1.0.0 
 * @createTime: 2024-07-29 20:31
 */
public class GraceExampleTool {

    private static final ThreadLocal<Long> LOCAL = new ThreadLocal<>();

    /**
     * execute
     *
     * @since 1.0.0
     * @param
     * @param flag
     * @param callback
     * @return: T
     * @author: panyong
     * @version: 1.0.0
     * @createTime: 2024-07-29 20:33
     */
    public static <T> T execute(Long flag, Callback<T> callback) {
        try {
            LOCAL.set(flag);
            return callback.call();

        } finally {
            LOCAL.remove();
        }
    }
}
