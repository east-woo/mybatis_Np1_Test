package com.eastwoo.mybatis_test.mapper;

import com.eastwoo.mybatis_test.dto.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * packageName    : com.eastwoo.mybatis_test.mapper
 * fileName       : OrderMapper
 * author         : dongwoo
 * date           : 2025-02-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-23        dongwoo       최초 생성
 */
@Mapper
public interface OrderMapper {
    void insertOrders(List<Order> orders); // 여러 주문 삽입
}
