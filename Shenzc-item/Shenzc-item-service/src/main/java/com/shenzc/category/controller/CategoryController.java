package com.shenzc.category.controller;

import com.shenzc.entity.Category;
import com.shenzc.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 婵大pig
 * @create 2019-08-22 15:31
 */
@RestController
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/list")
    public ResponseEntity<List<Category>> findByParentId(@RequestParam(value = "pid",defaultValue = "0") int pid){
        List<Category> categoryList = categoryService.findByParentId(pid);
        if (categoryList == null || categoryList.size()==0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(categoryList);
    }


}
