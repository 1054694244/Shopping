package com.shenzc.listener;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.shenzc.properties.SmsProperties;
import com.shenzc.utils.SmsUtil;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author shenzc
 * @create 2019-09-05-14:54
 */
@Component
@EnableConfigurationProperties(SmsProperties.class)
public class SmsListener {

    @Autowired
    private SmsUtil smsUtil;
    @Autowired
    private SmsProperties prop;


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "shenzc.sms.queue",durable = "true"),
            exchange = @Exchange(value = "shenzc.sms.exchange",
                                    ignoreDeclarationExceptions = "true"),
            key = {"sms.verify.code"}))
    public void listenSms(Map<String,String> msg) throws ClientException {
        if (msg == null || msg.size()<=0){
            //放弃处理
            return;
        }
        String phone = msg.get("phone");
        String code = msg.get("code");
        if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(code)){
            //放弃处理
            return;
        }
        SendSmsResponse sendSmsResponse = smsUtil.sendSms(phone, code, prop.getSignName(), prop.getVerifyCodeTemplate());

        //发送失败
        throw new RuntimeException();
    }


}
