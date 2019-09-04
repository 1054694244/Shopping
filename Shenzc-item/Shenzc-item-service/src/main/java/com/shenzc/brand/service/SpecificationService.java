package com.shenzc.brand.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.shenzc.brand.mapper.SpecificationMapper;
import com.shenzc.entity.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shenzc
 * @create 2019-09-02-9:01
 */
@Service
public class SpecificationService {

    @Autowired
    private SpecificationMapper specificationMapper;

    public List<Specification> findById(Integer categoryId){
        return specificationMapper.selectList(new EntityWrapper<Specification>().eq("category_id",categoryId));
    }



}
