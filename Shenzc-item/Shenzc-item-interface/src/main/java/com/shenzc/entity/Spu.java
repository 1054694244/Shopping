package com.shenzc.entity;

import lombok.Data;

import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author shenzc
 * @create 2019-09-02-10:12
 */
@Table(name = "spu")
@Data
public class Spu {

    private Integer id;

    private String title;

    private String subTitle;

    private Integer cid1;

    private Integer cid2;

    private Integer cid3;

    private Integer brandId;

    private Integer saleable;

    private Integer valid;

    private LocalDateTime createTime;

    private LocalDateTime lastUpdateTime;

}
