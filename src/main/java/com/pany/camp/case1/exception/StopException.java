package com.pany.camp.case1.exception;

/**
 *
 * @description: StopException
 * @copyright: @copyright (c) 2022
 * @company: aiocloud
 * @author: panyong
 * @version: 1.0.0
 * @createTime: 2024-07-29 11:00
 */
public class StopException extends Exception {

    public StopException() {
        super();
    }

    public StopException(String message) {
        super(message);
    }

    public StopException(String message, Throwable cause) {
        super(message, cause);
    }

    public StopException(Throwable cause) {
        super(cause);
    }

    protected StopException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
