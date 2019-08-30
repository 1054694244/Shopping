package com.shenzc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Table;

/**
 * @author shenzc
 * @create 2019-08-30-8:47
 */
@Table(name = "category_brand")
@Data
@AllArgsConstructor
public class CategoryBrand {

    private Integer categoryId;

    private Integer brandId;

}
