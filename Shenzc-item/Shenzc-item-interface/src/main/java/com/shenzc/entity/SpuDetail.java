package com.shenzc.entity;

import lombok.Data;

import javax.persistence.Table;

/**
 * @author shenzc
 * @create 2019-09-02-10:15
 */
@Data
@Table(name = "Spu_detail")
public class SpuDetail {

    private Integer spu_id;

    private String description;

    private String specifications;

    private String specTemplate;

    private String packingList;

    private String afterService;

}
