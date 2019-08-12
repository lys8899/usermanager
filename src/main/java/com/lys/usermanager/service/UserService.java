package com.lys.usermanager.service;


import com.lys.usermanager.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;
import java.util.Set;

/**
 * @description: 用户
 * @author: LiYongSen[825760990@qq.com]
 * @create: 2018-09-08 15:08
 **/
public interface UserService extends UserDetailsService {

    /**
     * 保存用户
     *
     * @param user
     * @return 保存后的对象
     */
    User saveUser(User user);

    /**
     * 根据用户id删除用户
     *
     * @param userIds
     */
    void deleteUsers(Set<String> userIds);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Optional<User> getUserById(String id);

    /**
     * @param name      姓名
     * @param pageable  分页
     * @return UserDO 用户信息
     * @Description 根据账号查询用户
     * @date 2017/11/30 15:5
     */
    Page<User> listTable(String name, Pageable pageable);
}
