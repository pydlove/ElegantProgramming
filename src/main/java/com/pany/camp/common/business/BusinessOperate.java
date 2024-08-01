package com.pany.camp.common.business;

import com.pany.camp.example.case2.main.ExampleTool;
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
     * @return: java.lang.String
     * @author: panyong
     * @version: 1.0.0
     * @createTime: 2024-07-29 21:06
     */
    public String execute() {

        Long flag = ExampleTool.getFlag();

        // 使用 flag 进行业务操作（Use flags for business operations）
        return "the code is very elegant, flag: " + flag;
    }

    /**
     * execute
     *
     * @since 1.0.0
     * @param
     * @author: panyong
     * @version: 1.0.0
     * @createTime: 2024-07-29 21:06
     */
    public void execute(Object code) {

        // 进行业务操作（for business operations）
        log.info("business operate, code: {}", code);
    }

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
