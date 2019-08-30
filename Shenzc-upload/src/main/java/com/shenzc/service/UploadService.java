package com.shenzc.service;

import com.shenzc.controller.UploadController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author shenzc
 * @create 2019-08-30-10:20
 */
@Service
public class UploadService {

    /**
     * 校验文件大小，
     * 校验文件的媒体类型，
     * 校验文件的内容
     */
    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

    //支持的文件类型
    private static final List<String> suffixes = Arrays.asList("image/png","image/jpeg");

    public String upload(MultipartFile file){
        try{
            //校验图片的类型
            String type = file.getContentType();
            if (!suffixes.contains(type)){
                logger.info("上传失败，文件类型不匹配：{}",type);
                return null;
            }
            //校验图片的内容
            BufferedImage image = ImageIO.read(file.getInputStream());
            if (null == image){
                logger.info("上传失败，文件内容不符合要求");
            }
            //保存图片
            //1：生成保存目录
            File dir = new File("D:\\java_file\\image");
            if (!dir.exists()){
                dir.mkdir();
            }
            //2：保存图片名
            File saveFile = new File(dir,file.getOriginalFilename());
            file.transferTo(saveFile);
            //3：拼接图片地址
            String url = "http://image.shenzc.com/"+file.getOriginalFilename();
            return url;
        }catch (IOException e){
            return null;
        }
    }

}
