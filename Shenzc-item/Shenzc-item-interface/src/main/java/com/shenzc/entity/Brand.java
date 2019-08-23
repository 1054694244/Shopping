package com.shenzc.entity;

import lombok.Data;

import javax.persistence.Table;

/**
 * @author 婵大pig
 * @create 2019-08-22 17:33
 */
@Table(name="brand")
@Data

public class Brand {

    private int id;

    private String name;

    private String image;

    private Character letter;

}
