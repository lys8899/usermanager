package com.lys.usermanager.service.impl;

import com.lys.usermanager.entity.SysFunction;
import com.lys.usermanager.entity.SysRowFunction;
import com.lys.usermanager.repository.FunctionRepository;
import com.lys.usermanager.repository.RowFunctionRepository;
import com.lys.usermanager.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @description:
 * @author: LiYongSen[825760990@qq.com]
 * @create: 2019-10-15 15:49
 **/
@Service
@CacheConfig(cacheNames = "Function")
public class FunctionServiceImpl implements FunctionService {

    @Autowired
    private FunctionRepository functionRepository;

    @Autowired
    private RowFunctionRepository rowFunctionRepository;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public SysFunction saveFunction(SysFunction function) {
        return functionRepository.save(function);
    }

    @Override
    public List<SysFunction> findFunctionsByRoleIds(Set<String> roleIds) {
        List<SysRowFunction> byFRoleId = rowFunctionRepository.findByFRoleIdIn(roleIds);
        List<SysFunction> sysFunctions = new ArrayList<>(byFRoleId.size());
        if (byFRoleId.isEmpty()) {
            return sysFunctions;
        }
        FunctionService contextBean = applicationContext.getBean(FunctionService.class);
        byFRoleId.forEach(sysRowFunction -> {
            Optional<SysFunction> byId = contextBean.findById(sysRowFunction.getfFunctionId());
            if (byId.isPresent()) {
                sysFunctions.add(byId.get());
            }
        });
        return sysFunctions;
    }

    @Cacheable(key = "#id", unless = "#result==null")
    @Override
    public Optional<SysFunction> findById(String id) {
        return functionRepository.findById(id);
    }
}
