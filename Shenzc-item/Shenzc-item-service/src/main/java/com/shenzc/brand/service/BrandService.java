package com.shenzc.brand.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shenzc.brand.mapper.BrandMapper;
import com.shenzc.common.PageResult;
import com.shenzc.entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public PageResult<Brand> findByAllBrand(Integer page, Integer rows, String sortBy, Boolean desc, String key){
        if (desc){
            PageHelper.startPage(page,rows,sortBy);
        }else {
            PageHelper.startPage(page,rows);
        }
        List<Brand> brandList = brandMapper.selectList(new EntityWrapper<Brand>());
        List<Brand> list = brandList.parallelStream().filter(
                brand ->
                    brand.getName().contains(key) || brand.getLetter().equals(key)
                )
                .collect(Collectors.toList());
        PageInfo<Brand> pageInfo = new PageInfo<>(list);
        return new PageResult<Brand>(pageInfo.getTotal(),pageInfo.getList());
    }

}
