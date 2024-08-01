package com.pany.camp.common.domain;

import lombok.Data;

/**
 *
 * @description:  UserPO
 * @copyright: @copyright (c) 2022 
 * @company: aiocloud
 * @author: panyong
 * @version: 1.0.0 
 * @createTime: 2024-08-01 13:21
 */
@Data
public class UserPO {

    private Long id;

    private String userName;

    private String roleName;

    private Integer age;

}
