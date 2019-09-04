package com.shenzc.brand.controller;

import com.shenzc.brand.service.SpuService;
import com.shenzc.common.PageResult;
import com.shenzc.entity.SpuBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shenzc
 * @create 2019-09-02-10:58
 */
@RestController
public class SpuController {

    @Autowired
    private SpuService spuService;

    @GetMapping("/spu/page")
    public ResponseEntity<PageResult<SpuBo>> getSpu(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                        @RequestParam(value = "rows",defaultValue = "5")Integer rows,
                                        @RequestParam(value = "saleable",defaultValue = "false")Boolean saleable,
                                        @RequestParam(value = "key",defaultValue = "")String key){
        PageResult<SpuBo> result = this.spuService.querySpuByPageAndSort(page, rows,saleable, key);
        /*if (result == null || result.getItems().size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }*/
        return ResponseEntity.ok(result);
    }

    /*@GetMapping("/spu/detail/{sid}")
    public ResponseEntity<SpuBo> getSpu(@PathVariable("sid")Integer sid){

    }*/

}
