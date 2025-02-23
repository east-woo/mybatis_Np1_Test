package com.eastwoo.mybatis_test.utill;

import com.eastwoo.mybatis_test.dto.Order;
import com.eastwoo.mybatis_test.dto.User;
import com.eastwoo.mybatis_test.mapper.OrderMapper;
import com.eastwoo.mybatis_test.mapper.UserMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataInitializer {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    private static final Random random = new Random();

    public void generateAndInsertData(int numberOfUsers) {
        for (int i = 0; i < numberOfUsers; i++) {
            User user = generateRandomUser(i + 1); // 사용자 데이터 생성
            userMapper.insertUser(user); // 사용자 삽입

            // 사용자에 해당하는 랜덤 주문 생성 후 삽입
            List<Order> orders = generateRandomOrders(user.getId(), 5); // 5개의 주문 예시
            user.setOrders(orders); // 사용자 객체에 주문 세팅
            orderMapper.insertOrders(orders); // 주문 삽입
        }
    }

    private User generateRandomUser(int userId) {
        String name = "User" + userId; // 사용자 이름
        return new User(userId, name, null);
    }

    private List<Order> generateRandomOrders(int userId, int numberOfOrders) {
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < numberOfOrders; i++) {
            int amount = random.nextInt(1000) + 1; // 1~1000 사이의 랜덤 금액
            orders.add(new Order(0, userId, amount)); // 주문 ID는 자동 생성되므로 0으로 설정
        }
        return orders;
    }
}