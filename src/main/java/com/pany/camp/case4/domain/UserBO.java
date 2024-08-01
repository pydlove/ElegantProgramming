package com.pany.camp.case4.domain;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 *
 * @description:  UserBO
 * @copyright: @copyright (c) 2022 
 * @company: aiocloud
 * @author: panyong
 * @version: 1.0.0 
 * @createTime: 2024-08-01 14:08
 */
@Data
public class UserBO {

    private List<String> userNames;

    private Map<String, String> roleNameMap;
}
