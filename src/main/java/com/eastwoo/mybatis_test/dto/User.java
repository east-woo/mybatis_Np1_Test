package com.eastwoo.mybatis_test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * packageName    : com.eastwoo.mybatis_test.dto
 * fileName       : UserDTO
 * author         : dongwoo
 * date           : 2025-02-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-23        dongwoo       최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private List<Order> orders;
}
