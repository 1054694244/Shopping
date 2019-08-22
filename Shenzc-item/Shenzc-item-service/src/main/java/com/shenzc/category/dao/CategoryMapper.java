package com.shenzc.category.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.shenzc.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;



/**
 * @author 婵大pig
 * @create 2019-08-22 15:32
 */
@Repository
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {



}
