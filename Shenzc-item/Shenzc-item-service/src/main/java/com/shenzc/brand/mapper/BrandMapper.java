package com.shenzc.brand.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.shenzc.entity.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 婵大pig
 * @create 2019-08-22 17:33
 */
@Repository
@Mapper
public interface BrandMapper extends BaseMapper<Brand> {
}
