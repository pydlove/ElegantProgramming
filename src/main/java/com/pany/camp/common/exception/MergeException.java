package com.pany.camp.common.exception;

/**
 *
 * @description: MergeException
 * @copyright: @copyright (c) 2022
 * @company: aiocloud
 * @author: panyong
 * @version: 1.0.0
 * @createTime: 2024-07-29 11:00
 */
public class MergeException extends Exception {

    public MergeException() {
        super();
    }

    public MergeException(String message) {
        super(message);
    }

    public MergeException(String message, Throwable cause) {
        super(message, cause);
    }

    public MergeException(Throwable cause) {
        super(cause);
    }

    protected MergeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
