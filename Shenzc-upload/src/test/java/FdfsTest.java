import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.domain.ThumbImageConfig;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.netflix.discovery.converters.Auto;
import com.shenzc.ShenzcUploadService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author shenzc
 * @create 2019-08-30-11:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShenzcUploadService.class)
public class FdfsTest {

    @Autowired
    private FastFileStorageClient storageClient;
    @Autowired
    private ThumbImageConfig imageConfig;

    @Test
    public void testUpload()throws FileNotFoundException{

        final Logger logger = LoggerFactory.getLogger(FdfsTest.class);

        File file = new File("C:\\Users\\10546\\Pictures\\Saved Pictures\\123.png");
        StorePath storePath = storageClient.uploadFile(new FileInputStream(file),file.length(),"png",null);
        logger.info(storePath.getFullPath());
        logger.info(storePath.getPath());
        String path = imageConfig.getThumbImagePath(storePath.getPath());
        logger.info(path);
    }

}
