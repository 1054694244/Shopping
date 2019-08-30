package com.shenzc.brand.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.shenzc.entity.Category;
import com.shenzc.entity.CategoryBrand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author shenzc
 * @create 2019-08-30-8:49
 */
@Mapper
@Repository
public interface CategoryBrandMapper extends BaseMapper<CategoryBrand> {

    int insertCategoryBrand(@Param("brandId") Integer brandId,
                            @Param("cids") List<Integer> cids);

    @Select("select * from category where id in (select category_id from category_brand where brand_id = #{brandId})")
    List<Category> selectCategory(@Param("brandId") Integer brandId);

}
