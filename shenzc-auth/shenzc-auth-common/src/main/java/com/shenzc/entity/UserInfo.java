package com.shenzc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 用户信息
 */
@Data
@AllArgsConstructor
public class UserInfo {

    private Long id;

    private String username;

}