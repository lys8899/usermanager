package com.lys.usermanager.controller;

import com.lys.usermanager.entity.Role;
import com.lys.usermanager.service.RoleService;
import com.lys.usermanager.until.ResponseDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 角色
 * @author: LiYongSen[825760990@qq.com]
 * @create: 2018-09-09 13:38
 **/
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseDate saveRole(Role role) {
        Role role1 = roleService.saveRole(role);
        return ResponseDate.successId(role1.getId());
    }
}
