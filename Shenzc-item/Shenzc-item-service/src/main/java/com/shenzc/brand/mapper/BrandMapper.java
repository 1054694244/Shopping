package com.shenzc.brand.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.shenzc.entity.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 婵大pig
 * @create 2019-08-22 17:33
 */
@Repository
@Mapper
public interface BrandMapper extends BaseMapper<Brand> {


    @Select("select * from brand a inner join category_brand b on b.category_id = #{cid} where a.id = b.brand_id")
    List<Brand> queryByCategoryId(@Param("cid") Integer cid);

}
