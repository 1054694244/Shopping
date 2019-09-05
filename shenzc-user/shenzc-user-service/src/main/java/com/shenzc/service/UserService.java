package com.shenzc.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.shenzc.mapper.UserMapper;
import com.shenzc.utils.CodecUtils;
import entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import com.shenzc.utils.NumberUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * @author shenzc
 * @create 2019-09-05-8:54
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private StringRedisTemplate redisTemplate;

    static final String KEY_PREFIX = "user:code:phone:";

    static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public Boolean check(String data,Integer type){
        int count = 0;
        switch (type){
            case 1:
                count = userMapper.selectCount(new EntityWrapper<User>().eq("username",data));
                break;
            case 2:
                count = userMapper.selectCount(new EntityWrapper<User>().eq("phone",data));
                break;
        }
        if (count>0){
            return true;
        }else {
            return false;
        }
    }

    public Boolean sendVerifyCode(String phone){
        //生成验证码
        String code = NumberUtils.generateCode(6);
        try{
            //发送短信
            Map<String,String> msg = new HashMap<>();
            msg.put("phone",phone);
            msg.put("code",code);
            amqpTemplate.convertAndSend("shenzc.sms.exchange","sms.verify.code",msg);
            //将code存入redis中
            redisTemplate.opsForValue().set(KEY_PREFIX+phone,code,5, TimeUnit.MINUTES);
            return true;
        }catch (Exception e){
            logger.error("发送短信失败。phone{},code{}",phone,code);
            return false;
        }
    }

    public Boolean register(User user,String code){
        String key = KEY_PREFIX+user.getPhone();
        //从redis中取出验证码
        String codeCache = redisTemplate.opsForValue().get(key);
        //检查验证码是否正确
        if (!code.equals(codeCache)){
            //不争取，返回false
            return false;
        }
        user.setId(null);
        user.setCreated(new Date());
        //生成盐
        String salt = "123";
        user.setSalt(salt);
        //对密码进行加密

        //写入数据库
        boolean boo = userMapper.insert(user)==1;

        //如果注册成功，删除redis中的凑得
        if (boo){
            try{
                redisTemplate.delete(key);
            }catch (Exception e){
                logger.error("删除缓存验证码失败");
            }
        }
        return boo;
    }

}
