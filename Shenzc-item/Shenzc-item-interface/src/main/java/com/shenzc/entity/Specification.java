package com.shenzc.entity;

import lombok.Data;

import javax.persistence.Table;

/**
 * @author shenzc
 * @create 2019-09-02-8:58
 */
@Table(name = "specification")
@Data
public class Specification {

    private Long categoryId;

    private String specifications;

}
