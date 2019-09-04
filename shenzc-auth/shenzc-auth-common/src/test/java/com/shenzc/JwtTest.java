package com.shenzc;

import com.shenzc.entity.UserInfo;
import com.shenzc.utils.JwtUtils;
import com.shenzc.utils.RsaUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author shenzc
 * @create 2019-09-04-17:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtTest {

    private static final String pubKeyPath = "D:\\Porject\\rsa\\rsa.pub";

    private static final String priKeyPath = "D:\\Porject\\rsa\\rsa.pri";

    private PublicKey publicKey;

    private PrivateKey privateKey;

    @Before
    public void testGetTsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

    @Test
    public void testRsa() throws Exception{
        RsaUtils.generateKey(pubKeyPath,priKeyPath,"234");
    }

    @Test
    public void testGenerateToken() throws Exception {
        //生成Token
        String token = JwtUtils.generateToken(new UserInfo(20L,"jack"),privateKey,5);
        System.out.println("token"+token);
    }

    @Test
    public void testParseToken() throws Exception {
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MjAsInVzZXJuYW1lIjoiamFjayIsImV4cCI6MTU2ODAyMjIzNX0.SbdD3RcSK21x9DyZaO5AfjaaR-ozA2GoCN962ZTbGtSwsIqtgT8xbg3da4WX-Ly7dNrdwKWYqQmzhxIYT8Rbn1-cb5sCD--XqlbOOAVvZTkpw67-JRyu6VZgHpK-NlqYqwuw78eJozMDtWPmfck3liu2dLEgWH7SlUAkzBD_0pk";
        //解析token
        UserInfo user = JwtUtils.getInfoFromToken(token,publicKey);
        System.out.println(user.getId());
        System.out.println(user.getUsername());
    }
}
