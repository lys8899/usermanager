package com.lys.usermanager.service.impl;

import com.lys.usermanager.entity.Role;
import com.lys.usermanager.entity.User;
import com.lys.usermanager.repository.UserRepository;
import com.lys.usermanager.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @description: 用户
 * @author: LiYongSen[825760990@qq.com]
 * @create: 2018-09-08 15:08
 **/
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository repository;

    @Override
    public User saveUser(User user) {
        String password = user.getPassword();
        password = new BCryptPasswordEncoder().encode(password);
        user.setPassword(password);

        return repository.save(user);
    }

    @Override
    public void deleteUsers(Set<User> users) {
        repository.deleteInBatch(users);
    }

    public User updateUser(User user) {
        return repository.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        User byAccount = repository.findByAccount(account);
        if (byAccount == null) {
            throw new UsernameNotFoundException("not search by account ");
        }

        if (null != byAccount.getRoles()) {
            for (Role role : byAccount.getRoles()) {
                role.getFunctions();
            }
        }


        return byAccount;
    }


}
