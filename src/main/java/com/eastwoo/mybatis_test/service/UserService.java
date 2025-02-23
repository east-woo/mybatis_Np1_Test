package com.eastwoo.mybatis_test.service;

import com.eastwoo.mybatis_test.dto.User;
import com.eastwoo.mybatis_test.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> getUsersWithOrders_NestedSelect() {
        return userMapper.getUsersWithOrdersNestedSelect();
    }

    public List<User> getUsersWithOrders_NestedResult() {
        return userMapper.getUsersWithOrdersNestedResult();
    }
}