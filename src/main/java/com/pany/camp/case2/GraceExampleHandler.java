package com.pany.camp.case2;

/**
 * @description: GraceExampleHandler
 * @copyright: @copyright (c) 2022
 * @company: aiocloud
 * @author: panyong
 * @version: 1.0.0
 * @createTime: 2024-07-29 20:17
 */
public class GraceExampleHandler {

    public void handle() {
        GraceExampleTool.execute(10086L, () -> {
            BusinessOperate businessOperate = new BusinessOperate();
            return businessOperate.execute();
        });
    }
}
