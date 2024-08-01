package com.pany.camp.case4.main;

import cn.hutool.core.collection.CollUtil;
import com.pany.camp.case4.domain.UserPO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @description: ExampleHandler
 * @copyright: @copyright (c) 2022 
 * @company: aiocloud
 * @author: panyong
 * @version: 1.0.0 
 * @createTime: 2024-08-01 13:17
 */
public class ExampleHandler {

    public void handle() {

        List<String> userNames = new ArrayList<>();
        Map<String, String> roleNameMap = new HashMap<>();
        getUserAndRoleNames(userNames, roleNameMap);

        BusinessOperate businessOperate = new BusinessOperate();
        businessOperate.execute(userNames, roleNameMap);
    }

    private void getUserAndRoleNames(List<String> userNames, Map<String, String> roleNameMap) {

        List<UserPO> users = select();
        if (CollUtil.isNotEmpty(users)) {
            for (UserPO user : users) {
                String userName = user.getUserName();
                String roleName = user.getRoleName();

                userNames.add(userName);
                roleNameMap.put(userName, roleName);
            }
        }
    }

    private List<UserPO> select() {

        // 假设这里是操作数据库的，查询出用户的信息数据
        return new ArrayList<>();
    }
}
