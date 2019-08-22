package com.shenzc.brand.controller;


import com.shenzc.brand.service.BrandService;
import com.shenzc.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 婵大pig
 * @create 2019-08-22 17:32
 */
@RestController
public class BrandController {

    @Autowired
    private BrandService brandService;
///brand/page?key=&page=1&rows=5&sortBy=id&desc=false
    @GetMapping("/brand/page")
    public ResponseEntity<List<Category>> findAllBrand(@RequestParam(value = "key",defaultValue = "") String key,
                                                       @RequestParam(value = "page",defaultValue = "") int page,
                                                       @RequestParam(value = "rows",defaultValue = "") int rows,
                                                       @RequestParam(value = "sortBy",defaultValue = "") int sortBy,
                                                       @RequestParam(value = "desc",defaultValue = "") boolean desc){
            return  null;
    }

}
