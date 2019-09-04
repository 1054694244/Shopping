package com.shenzc.properties;

import com.shenzc.utils.RsaUtils;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import java.io.File;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author shenzc
 * @create 2019-09-04-17:50
 */
@Data
@ConfigurationProperties(prefix = "shenzc.jwt")
public class JwtProperties {

    //密钥
    private String secret;

    //公钥
    private String pubkeyPath;

    //私钥
    private String priKeyPath;

    //token过期时间
    private int expire;

    //公钥
    private PublicKey publicKey;

    //私钥
    private PrivateKey privateKey;

    private static final Logger logger = LoggerFactory.getLogger(JwtProperties.class);

    /**
     * 在构造方法执行之后执行该方法
     */
    @PostConstruct
    public void init(){
        try{
            File pubKey = new File(pubkeyPath);
            File priKey = new File(priKeyPath);
            if (!pubKey.exists() || !priKey.exists()){
                //生成公钥和密码
                RsaUtils.generateKey(pubkeyPath,priKeyPath,secret);
            }
        }catch (Exception e){
            logger.error("初始化公钥和私钥失败",e);
            throw new RuntimeException();
        }
    }

}
