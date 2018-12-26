package com.lys.usermanager.service;


import com.lys.usermanager.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Set;

/**
 * @description: 用户
 * @author: LiYongSen[825760990@qq.com]
 * @create: 2018-09-08 15:08
 **/
public interface UserService extends UserDetailsService {

    User saveUser(User user);

    void deleteUsers(Set<User> users);
}
