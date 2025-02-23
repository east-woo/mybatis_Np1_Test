package com.eastwoo.mybatis_test.controller;

import com.eastwoo.mybatis_test.dto.User;
import com.eastwoo.mybatis_test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/with-orders/nested-select")
    public List<User> getUsersWithOrders_NestedSelect() {
        return userService.getUsersWithOrders_NestedSelect();
    }

    @GetMapping("/with-orders/nested-result")
    public List<User> getUsersWithOrders_NestedResult() {
        return userService.getUsersWithOrders_NestedResult();
    }
}