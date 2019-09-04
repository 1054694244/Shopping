package com.shenzc.entity;

import lombok.Data;

import javax.persistence.Table;

/**
 * @author shenzc
 * @create 2019-09-02-14:12
 */
@Table(name = "stock")
@Data
public class Stock {

    private Integer SkuId;

    private Integer seckillStock;

    private Integer seckillTotal;

    private Integer stock;

}
