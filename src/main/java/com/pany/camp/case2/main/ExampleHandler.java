package com.pany.camp.case2.main;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @description: ExampleHandler
 * @copyright: @copyright (c) 2022 
 * @company: aiocloud
 * @author: panyong
 * @version: 1.0.0 
 * @createTime: 2024-07-29 20:17
 */
@Slf4j
public class ExampleHandler {

    public void handle() {

        try {
            ExampleTool.setFlag(10086L);

            BusinessOperate businessOperate = new BusinessOperate();
            String result = businessOperate.execute();
            log.info("business operate result is : {}", result);

        } finally {
            ExampleTool.removeFlag();
        }
    }
}