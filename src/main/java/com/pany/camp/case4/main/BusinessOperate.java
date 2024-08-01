package com.pany.camp.case4.main;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

/**
 *
 * @description: BusinessOperate
 * @copyright: @copyright (c) 2022
 * @company: aiocloud
 * @author: panyong
 * @version: 1.0.0
 * @createTime: 2024-07-29 20:23
 */
@Slf4j
public class BusinessOperate {

    /**
     * execute
     *
     * @since 1.0.0
     * @param
     * @param roleNameMap
     * @author: panyong
     * @version: 1.0.0
     * @createTime: 2024-07-29 21:06
     */
    public void execute(List<String> userNames, Map<String, String> roleNameMap) {

        // 进行业务操作（for business operations）
        log.info("business operate, userNames: {}, roleNames: {}", userNames, roleNameMap);
    }
}
