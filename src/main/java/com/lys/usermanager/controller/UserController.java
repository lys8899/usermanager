package com.lys.usermanager.controller;

import com.lys.usermanager.entity.User;
import com.lys.usermanager.service.UserService;
import com.lys.usermanager.until.ResponseDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 用户
 * @author: LiYongSen[825760990@qq.com]
 * @create: 2018-09-08 15:10
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseDate saveUser(User user) {
        User u = userService.saveUser(user);
        return ResponseDate.successId(u.getId());
    }


}
