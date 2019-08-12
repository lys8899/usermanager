package com.lys.usermanager.controller;


import com.google.common.base.Strings;
import com.lys.usermanager.entity.User;
import com.lys.usermanager.service.UserService;
import com.lys.usermanager.until.ResponseDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

/**
 * @description: 用户
 * @author: LiYongSen[825760990@qq.com]
 * @create: 2018-09-08 15:10
 **/
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseDate saveUser(User user) {

        if (Objects.nonNull(user)) {
            if (Strings.isNullOrEmpty(user.getId())) {
                User u = userService.saveUser(user);
                return ResponseDate.successId(u.getId());
            }
        }
        return ResponseDate.error(user, "错误参数或不应存在id");
    }

    @GetMapping("/{userId}")
    public ResponseDate getUser(@PathVariable String userId) {
        if (Strings.isNullOrEmpty(userId)) {
            return ResponseDate.error(null, "id不能为空");
        }
        Optional<User> userById = userService.getUserById(userId);
        if (userById.isPresent()) {
            return ResponseDate.successId(userById.get());
        }
        return ResponseDate.error(null, "用户不存在");
    }

    @GetMapping
    public ResponseDate getUsers(@PageableDefault Pageable pageable,
                                 String name) {
        Page<User> users = userService.listTable(name, pageable);
        return ResponseDate.success(users);
    }


}
