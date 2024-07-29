package com.pany.camp.case1;

import com.pany.camp.case1.exception.*;
import lombok.extern.slf4j.Slf4j;

/**
 * @description: GraceExampleHandler
 * @copyright: @copyright (c) 2022
 * @company: aiocloud
 * @author: panyong
 * @version: 1.0.0
 * @createTime: 2024-07-29 12:07
 */
@Slf4j
public class GraceExampleHandler extends CommonHandler {

    /**
     * handle
     *
     * @param
     * @return: void
     * @author: panyong
     * @version: 1.0.0
     * @createTime: 2024-07-29 12:07
     * @since 1.0.0
     */
    public void handle() {
        try {

            // Here are some business operations
            doBusinessOperate();

        } catch (Exception ex) {

            log.error("handle fail, caused by: ", ex);
            handleException(ex);
        }
    }

    /**
     * handleException
     *
     * @param
     * @param ex
     * @return: void
     * @author: panyong
     * @version: 1.0.0
     * @createTime: 2024-07-29 13:12
     * @since 1.0.0
     */
    private void handleException(Exception ex) {

        if (ex instanceof AuthorizeException) {
            doAuthorizeException();
        } else if (ex instanceof CheckException) {
            doCheckException();
        } else if (ex instanceof ConnectException) {
            doConnectException();
        } else if (ex instanceof StopException) {
            doStopException();
        } else if (ex instanceof MergeException) {
            doMergeException();
        } else {
            doException();
        }
    }
}
