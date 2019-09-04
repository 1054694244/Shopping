package com.shenzc.brand.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.netflix.discovery.converters.Auto;
import com.shenzc.brand.mapper.BrandMapper;
import com.shenzc.brand.mapper.SpuDetailMapper;
import com.shenzc.brand.mapper.SpuMapper;
import com.shenzc.category.dao.CategoryMapper;
import com.shenzc.category.service.CategoryService;
import com.shenzc.common.PageResult;
import com.shenzc.entity.Brand;
import com.shenzc.entity.Spu;
import com.shenzc.entity.SpuBo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.MathContext;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shenzc
 * @create 2019-09-02-10:22
 */
@Service
public class SpuService {

    @Autowired
    private SpuMapper spuMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private BrandMapper brandMapper;

    public PageResult<SpuBo> querySpuByPageAndSort(Integer page,Integer rows,Boolean saleable,String key){
        List<Spu> spuList = spuMapper.selectList(new EntityWrapper<Spu>());
        List<SpuBo> collect = spuList.stream()
                .filter(spu -> spu.getTitle().contains(key) && saleable==false?spu.getSaleable() == 0:spu.getSaleable() == 1)
                .map(spu -> {
                    SpuBo spuBo = new SpuBo();
                    //属性拷贝
                    BeanUtils.copyProperties(spu, spuBo);
                    List<String> names = categoryMapper.selectName(spu.getCid1(), spu.getCid2(), spu.getCid3());
                    spuBo.setCname(StringUtils.join(names, "/"));
                    Brand brand = brandMapper.selectById(spu.getBrandId());
                    spuBo.setBname(brand.getName());
                    return spuBo;
                })
                .collect(Collectors.toList());
        PageHelper.startPage(page, Math.min(rows, 100));
        PageInfo<SpuBo> pageInfo = new PageInfo<>(collect);
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }




}
