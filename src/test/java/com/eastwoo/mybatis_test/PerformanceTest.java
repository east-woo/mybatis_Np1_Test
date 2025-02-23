package com.eastwoo.mybatis_test;

import com.eastwoo.mybatis_test.dto.User;
import com.eastwoo.mybatis_test.service.UserService;
import com.eastwoo.mybatis_test.utill.DataInitializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class PerformanceTest {

    @Autowired
    private DataInitializer dataInitializer;

    @Autowired
    private UserService userService;

    @BeforeEach
    @Transactional
    public void setUp() {
        // 데이터베이스가 비어 있으면 랜덤 데이터를 삽입
        if (userService.getUsersWithOrders_NestedSelect().isEmpty()) {
            dataInitializer.generateAndInsertData(1000); // 1000개의 랜덤 데이터 삽입
        }
    }

    @Test
    public void test_NPlusOne_NestedSelect() {
        long startTime = System.currentTimeMillis();
        
        // N+1 문제를 발생시키는 메소드 호출
        List<User> usersWithOrders = userService.getUsersWithOrders_NestedSelect();
        
        long endTime = System.currentTimeMillis();
        System.out.println("N+1 발생 방식 시간: " + (endTime - startTime) + "ms");
    }

    @Test
    public void test_NPlusOne_Solved_NestedResult() {
        long startTime = System.currentTimeMillis();
        
        // N+1 문제를 해결한 메소드 호출
        List<User> usersWithOrders = userService.getUsersWithOrders_NestedResult();
        
        long endTime = System.currentTimeMillis();
        System.out.println("N+1 해결 방식 시간: " + (endTime - startTime) + "ms");
    }
}