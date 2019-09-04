package com.shenzc.category.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.shenzc.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author 婵大pig
 * @create 2019-08-22 15:32
 */
@Repository
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {


    @Select("select name from category where id in (#{id1},#{id2},#{id3})")
    List<String> selectName(@Param("id1") Integer id1, @Param("id2") Integer id2, @Param("id3") Integer id3);

}
