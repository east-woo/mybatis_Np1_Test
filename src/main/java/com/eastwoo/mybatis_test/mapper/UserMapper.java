package com.eastwoo.mybatis_test.mapper;

import com.eastwoo.mybatis_test.dto.Order;
import com.eastwoo.mybatis_test.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * packageName    : com.eastwoo.mybatis_test.mapper
 * fileName       : UserMapper
 * author         : dongwoo
 * date           : 2025-02-03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-03        dongwoo       최초 생성
 */
@Mapper
public interface UserMapper {
    void insertUser(User user); // 사용자 삽입

    List<User> getUsersWithOrdersNestedSelect(); // N+1 발생 방식
    List<User> getUsersWithOrdersNestedResult(); // N+1 해결 방식
}