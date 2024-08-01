package com.pany.camp.common.exception;

/**
 *
 * @description: UnRegisterException
 * @copyright: @copyright (c) 2022
 * @company: aiocloud
 * @author: panyong
 * @version: 1.0.0
 * @createTime: 2024-07-29 11:00
 */
public class UnRegisterException extends Exception {

    public UnRegisterException() {
        super();
    }

    public UnRegisterException(String message) {
        super(message);
    }

    public UnRegisterException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnRegisterException(Throwable cause) {
        super(cause);
    }

    protected UnRegisterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
