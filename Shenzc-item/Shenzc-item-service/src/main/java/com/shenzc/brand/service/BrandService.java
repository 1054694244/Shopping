package com.shenzc.brand.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.netflix.discovery.converters.Auto;
import com.shenzc.brand.mapper.BrandMapper;
import com.shenzc.brand.mapper.CategoryBrandMapper;
import com.shenzc.category.dao.CategoryMapper;
import com.shenzc.category.service.CategoryService;
import com.shenzc.common.PageResult;
import com.shenzc.entity.Brand;
import com.shenzc.entity.Category;
import com.shenzc.entity.CategoryBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 婵大pig
 * @create 2019-08-22 17:33
 */
@Service
public class BrandService {

    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private CategoryBrandMapper categoryBrandMapper;

    /**
     * 分页查询品牌
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @param key
     * @return
     */
    public PageResult<Brand> findByAllBrand(Integer page, Integer rows, String sortBy, Boolean desc, String key){
        if (desc){
            PageHelper.startPage(page,rows,sortBy);
        }else {
            PageHelper.startPage(page,rows);
        }
        List<Brand> brandList = brandMapper.selectList(new EntityWrapper<Brand>());
        List<Brand> list = brandList.parallelStream().filter(
                brand ->
                    !brand.getName().contains(key) || !brand.getLetter().equals(key)
                )
                .collect(Collectors.toList());
        PageInfo<Brand> pageInfo = new PageInfo<>(list);
        return new PageResult<Brand>(pageInfo.getTotal(),pageInfo.getList());
    }

    @Transactional
    public void saveBrand(Brand brand,List<Integer> cids){
        //新增品牌信息
        brandMapper.insert(brand);
        //新增品牌和分类中间表
        categoryBrandMapper.insertCategoryBrand(brand.getId(),cids);
        /*for (Integer i : cids){
            CategoryBrand categoryBrand = new CategoryBrand(i,brand.getId());
            categoryBrandMapper.insert(categoryBrand);
        }*/
    }

    @Transactional
    public void updateBrand(Brand brand,List<Integer> cids){
        //跟新品牌信息
        brandMapper.update(brand,new EntityWrapper<Brand>().eq("id",brand.getId()));
        //跟新品牌和分类中间表
        categoryBrandMapper.delete(new EntityWrapper<CategoryBrand>().eq("brand_id",brand.getId()));
        for (Integer i : cids){
            CategoryBrand categoryBrand = new CategoryBrand(i,brand.getId());
            categoryBrandMapper.insert(categoryBrand);
        }
    }

    /**
     * 通过品牌ID查找分类
     */
    public List<Category> findByCategoryId(Integer brandId){
        return categoryBrandMapper.selectCategory(brandId);
    }

    /**
     * 删除品牌
     */
    public void deleteBrand(Integer brandId){
        //删除品牌数据
        brandMapper.deleteById(brandId);
        //删除品牌分类数据
        categoryBrandMapper.delete(new EntityWrapper<CategoryBrand>().eq("brand_id", brandId));
    }

}
