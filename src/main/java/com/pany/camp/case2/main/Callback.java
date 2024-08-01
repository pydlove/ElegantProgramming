package com.pany.camp.case2.main;

/**
 *
 * @description: Callback
 * @copyright: @copyright (c) 2022 
 * @company: aiocloud
 * @author: panyong
 * @version: 1.0.0 
 * @createTime: 2024-07-29 20:29
 */
@FunctionalInterface
public interface Callback<T> {

    T call();
}
