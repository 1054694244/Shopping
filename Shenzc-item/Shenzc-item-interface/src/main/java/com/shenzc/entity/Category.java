package com.shenzc.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author 婵大pig
 * @create 2019-08-22 15:24
 */
@Table(name = "category")
@Data
public class Category {

    private int id;

    private String name;

    private int parentId;

    private int isParent;

    private int sort;

}
