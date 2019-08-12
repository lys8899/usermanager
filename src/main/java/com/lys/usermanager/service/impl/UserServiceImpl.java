package com.lys.usermanager.service.impl;

import com.google.common.base.Strings;
import com.lys.usermanager.entity.Role;
import com.lys.usermanager.entity.User;
import com.lys.usermanager.repository.UserRepository;
import com.lys.usermanager.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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
        if (!Strings.isNullOrEmpty(password)) {
            password = new BCryptPasswordEncoder().encode(password);
            user.setPassword(password);
        }
        return repository.save(user);
    }

    @Override
    public void deleteUsers(Set<String> userIds) {
        Set<User> collect = userIds.stream().map(id -> {
            User user = new User();
            user.setId(id);
            return user;
        }).collect(Collectors.toSet());

        repository.deleteInBatch(collect);
    }


    @Override
    public Optional<User> getUserById(String id) {
        Optional<User> byId = repository.findById(id);
        return byId;
    }


    @Override
    public Page<User> listTable(String name, Pageable pageable) {
        Specification<User> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (!Strings.isNullOrEmpty(name)) {
                predicates.add(criteriaBuilder.like(root.get("name").as(String.class), name));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };

        return repository.findAll(specification, pageable);

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
