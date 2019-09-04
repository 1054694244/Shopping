package com.shenzc.brand.controller;


import com.shenzc.brand.service.BrandService;
import com.shenzc.common.PageResult;
import com.shenzc.entity.Brand;
import com.shenzc.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 婵大pig
 * @create 2019-08-22 17:32
 */
@RestController
public class BrandController {

    @Autowired
    private BrandService brandService;

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


    /**
     * 新增品牌
     */
    @PostMapping("/brand")
    public ResponseEntity<Void> saveBrand(Brand brand,@RequestParam("cids")List<Integer> cids){
        this.brandService.saveBrand(brand,cids);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * 修改品牌
     * @param
     * @return
     */
    @PutMapping("/brand")
    public ResponseEntity<Void> updagteBrand(Brand brand,@RequestParam("cids")List<Integer> cids){
        this.brandService.updateBrand(brand,cids);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping("/brandId/{brandId}")
    public ResponseEntity<List<Category>> queryByBrandId(@PathVariable("brandId") Integer brandId){
        List<Category> categories = brandService.findByCategoryId(brandId);
        /*if (categories == null || categories.size() < 1) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }*/
        return ResponseEntity.ok(categories);
    }

    @DeleteMapping("/brandId/{brandId}")
    public ResponseEntity deleteBrand(@PathVariable("brandId")Integer brandId){
        brandService.deleteBrand(brandId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/brand/cid/{cid}")
    public ResponseEntity<List<Brand>> queryBrandByCategory(@PathVariable("cid")Integer cid){
        List<Brand> brands = brandService.queryBrandByCategory(cid);
        return ResponseEntity.ok(brands);
    }

}
