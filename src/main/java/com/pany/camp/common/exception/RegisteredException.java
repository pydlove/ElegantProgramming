package com.pany.camp.common.exception;

/**
 *
 * @description: AuthorizeException
 * @copyright: @copyright (c) 2022
 * @company: aiocloud
 * @author: panyong
 * @version: 1.0.0
 * @createTime: 2024-07-29 11:00
 */
public class RegisteredException extends Exception {

    public RegisteredException() {
        super();
    }

    public RegisteredException(String message) {
        super(message);
    }

    public RegisteredException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegisteredException(Throwable cause) {
        super(cause);
    }

    protected RegisteredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
