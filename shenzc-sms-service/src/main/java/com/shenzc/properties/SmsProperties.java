package com.shenzc.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author shenzc
 * @create 2019-09-05-11:53
 */
@Data
@AllArgsConstructor
@ConfigurationProperties(prefix = "shenzc.sms")
@Component
public class SmsProperties {

    private String accessKeyId;

    private String accessKeySecret;

    private String signName;

    private String verifyCodeTemplate;



}
