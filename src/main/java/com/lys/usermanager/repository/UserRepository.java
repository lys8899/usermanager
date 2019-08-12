package com.lys.usermanager.repository;

import com.lys.usermanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @description: 用户Repository
 * @author: LiYongSen[825760990@qq.com]
 * @create: 2018-09-08 15:00
 **/
public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {


    /**
     * 根据账号查询用户
     *
     * @param account 账号
     * @return UserDO 用户信息
     * @date 2017/11/30 15:5
     */
    User findByAccount(String account);
}
