package com.lys.usermanager.service.impl;

import com.lys.usermanager.entity.Role;
import com.lys.usermanager.repository.RoleRepository;
import com.lys.usermanager.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 角色
 * @author: LiYongSen[825760990@qq.com]
 * @create: 2018-09-09 13:41
 **/
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }
}
