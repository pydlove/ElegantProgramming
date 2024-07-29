package com.pany.camp.case2;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @description: Example3Handler
 * @copyright: @copyright (c) 2022 
 * @company: aiocloud
 * @author: panyong
 * @version: 1.0.0 
 * @createTime: 2024-07-29 20:17
 */
@Slf4j
public class Example3Handler {

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