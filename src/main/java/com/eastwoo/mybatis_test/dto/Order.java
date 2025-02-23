package com.eastwoo.mybatis_test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * packageName    : com.eastwoo.mybatis_test.dto
 * fileName       : OrderDTO
 * author         : dongwoo
 * date           : 2025-02-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-23        dongwoo       최초 생성
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Order {
    private int id;
    private int userId;
    private int amount;

}
