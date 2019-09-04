package com.shenzc.controller;

import com.shenzc.properties.JwtProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shenzc
 * @create 2019-09-04-18:02
 */
@RestController
@EnableConfigurationProperties(JwtProperties.class)
public class AuthController {



}
