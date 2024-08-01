package com.pany.camp.example.case4.main;

import cn.hutool.core.collection.CollUtil;
import com.pany.camp.common.business.BusinessOperate;
import com.pany.camp.common.domain.UserBO;
import com.pany.camp.common.domain.UserPO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @description: GraceExampleHandler
 * @copyright: @copyright (c) 2022 
 * @company: aiocloud
 * @author: panyong
 * @version: 1.0.0 
 * @createTime: 2024-08-01 13:17
 */
public class GraceExampleHandler {

    public void handle() {

        UserBO userBO = getUserAndRoleNames();

        BusinessOperate businessOperate = new BusinessOperate();
        businessOperate.execute(userBO.getUserNames(), userBO.getRoleNameMap());
    }

    private UserBO getUserAndRoleNames() {

        List<String> userNames = new ArrayList<>();
        Map<String, String> roleNameMap = new HashMap<>();

        List<UserPO> users = select();
        if (CollUtil.isNotEmpty(users)) {
            for (UserPO user : users) {
                String userName = user.getUserName();
                String roleName = user.getRoleName();

                userNames.add(userName);
                roleNameMap.put(userName, roleName);
            }
        }

        UserBO userBO = new UserBO();
        userBO.setUserNames(userNames);
        userBO.setRoleNameMap(roleNameMap);

        return userBO;
    }

    private List<UserPO> select() {

        // 假设这里是操作数据库的，查询出用户的信息数据
        return new ArrayList<>();
    }
}
