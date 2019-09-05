package com.shenzc.controller;

import com.shenzc.service.UserService;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author shenzc
 * @create 2019-09-05-8:55
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/check/{data}/{type}")
    public ResponseEntity<Boolean> check(@PathVariable(value = "data",required = true)String data,
                                         @PathVariable(value = "type") Integer type){
        if (null == type){
            type = 1;
        }
        boolean check = userService.check(data, type);
        if (!check){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }else {
            return ResponseEntity.ok(check);
        }
    }


    @PostMapping("code")
    public ResponseEntity<Void> sendVerifyCode(String phone){
        Boolean boo = userService.sendVerifyCode(phone);
        if (!boo || boo==null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("register")
    public ResponseEntity<Void> register(User user, @RequestParam("code")String code){
        Boolean boo = userService.register(user,code);
        if (boo==null || !boo){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
