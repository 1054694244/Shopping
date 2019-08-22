package com.shenzc.brand.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.shenzc.brand.mapper.BrandMapper;
import com.shenzc.entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 婵大pig
 * @create 2019-08-22 17:33
 */
@Service
public class BrandService {

    @Autowired
    private BrandMapper brandMapper;

    public List<Brand> findByAllBrand(){
        List<Brand> brandList = brandMapper.selectList(new EntityWrapper<Brand>());
        return brandList;
    }

}
