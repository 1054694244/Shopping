package com.shenzc.brand.controller;

import com.shenzc.brand.service.SpecificationService;
import com.shenzc.entity.Brand;
import com.shenzc.entity.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;

/**
 * @author shenzc
 * @create 2019-09-02-9:03
 */
@RestController
public class SpecificationController {

    @Autowired
    private SpecificationService specificationService;

    @GetMapping("spec/{cid}")
    public ResponseEntity<String> getSpecification(@PathVariable("cid")Integer cid){
        List<Specification> specifications = specificationService.findById(cid);
        /*if (null == specifications || specifications.size()==0 ){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return ResponseEntity.ok(specifications.get(0).getSpecifications());
        }*/
        return ResponseEntity.ok(specifications.get(0).getSpecifications());
    }


    @GetMapping("/spec/params")
    public ResponseEntity<String> queryBrandByCategory(@RequestParam("gid")Integer gid,
                                                       @RequestParam("cid")Integer cid,
                                                       @RequestParam("searching")Boolean searching,
                                                       @RequestParam("generic")Boolean generic){
        List<Specification> specifications = specificationService.findById(cid);
        if (specifications == null){
            return null;
        }else {
            return ResponseEntity.ok(specifications.get(0).getSpecifications());
        }
    }

}
