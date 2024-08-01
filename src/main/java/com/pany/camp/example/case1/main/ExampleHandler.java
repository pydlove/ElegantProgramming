package com.pany.camp.example.case1.main;

import com.pany.camp.common.exception.*;
import lombok.extern.slf4j.Slf4j;

/**
 * @description: ExampleHandler
 * @copyright: @copyright (c) 2022
 * @company: aiocloud
 * @author: panyong
 * @version: 1.0.0
 * @createTime: 2024-07-29 9:21
 */
@Slf4j
public class ExampleHandler extends CommonHandler {

    /**
     * handle
     *
     * @param
     * @return: void
     * @author: panyong
     * @version: 1.0.0
     * @createTime: 2024-07-29 9:25
     * @since 1.0.0
     */
    public void handle() {

        try {

            // Here are some business operations
            doBusinessOperate();

        } catch (AuthorizeException ex) {

            log.error("handle fail, caused by: ", ex);
            doAuthorizeException();

        } catch (CheckException ex) {

            log.error("handle fail, caused by: ", ex);
            doCheckException();

        } catch (ConnectException ex) {

            log.error("handle fail, caused by: ", ex);
            doConnectException();

        } catch (StopException ex) {

            log.error("handle fail, caused by: ", ex);
            doStopException();

        } catch (MergeException ex) {

            log.error("handle fail, caused by: ", ex);
            doMergeException();

        } catch (Exception ex) {

            log.error("handle fail, caused by: ", ex);
            doException();
        }
    }
}
