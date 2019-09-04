package com.shenzc.category.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.shenzc.category.dao.CategoryMapper;
import com.shenzc.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 婵大pig
 * @create 2019-08-22 15:32
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 根据parentId查询子类
     */
    public List<Category> findByParentId(int parentId){
        return categoryMapper.selectList(new EntityWrapper<Category>().eq("parent_id", parentId));
    }

    public List<String> findNameById(Integer id1,Integer id2,Integer id3){
        return categoryMapper.selectName(id1,id2,id3);
    }

}
