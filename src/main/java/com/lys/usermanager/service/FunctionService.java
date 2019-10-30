package com.lys.usermanager.service;

import com.lys.usermanager.entity.SysFunction;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @description: 权限
 * @author: LiYongSen[825760990@qq.com]
 * @create: 2018-09-09 13:39
 **/
public interface FunctionService {

    SysFunction saveFunction(SysFunction function);

    List<SysFunction> findFunctionsByRoleIds(Set<String> stringSet);

    Optional<SysFunction> findById(String id);
}
