package com.shenzc.brand.controller;


import com.shenzc.brand.service.BrandService;
import com.shenzc.common.PageResult;
import com.shenzc.entity.Brand;
import com.shenzc.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<PageResult<Brand>> findAllBrand(@RequestParam(value = "key",defaultValue = "") String key,
                                                       @RequestParam(value = "page",defaultValue = "1") Integer page,
                                                       @RequestParam(value = "rows",defaultValue = "5") Integer rows,
                                                       @RequestParam(value = "sortBy",defaultValue = "") String sortBy,
                                                       @RequestParam(value = "desc",defaultValue = "false") boolean desc){
        PageResult<Brand> result = brandService.findByAllBrand(page, rows, sortBy, desc, key);
        if (null == result || result.getItems().size() == 0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return ResponseEntity.ok(result);
        }
    }

}
