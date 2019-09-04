package com.shenzc.entity;

import com.sun.xml.internal.ws.spi.db.DatabindingException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author shenzc
 * @create 2019-09-04-15:11
 */
@Data
@AllArgsConstructor
@Document(indexName = "goods",type = "docs",shards = 1,replicas = 0)
public class Goods {

    @Id
    private Long id;

    // 所有需要被搜索的信息，包含标题，分类，甚至品牌
    @Field(type = FieldType.text,analyzer = "ik_max_word")
    private String all;//所需要被搜索的信息，包含标题，分类，甚至品牌

    // 卖点
    @Field(type = FieldType.keyword,index = false)
    private String subTitle;

    private Long brandId;

    private Long cid1;

    private Long cid2;

    private Long cid3;

    private Date createTime;

    private List<Long> price;

    // sku信息的json结构
    @Field(type = FieldType.keyword,index = false)
    private String skus;

    // 可搜索的规格参数，key是参数名，值是参数值
    private Map<String,Object> specs;

}
