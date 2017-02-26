package cn.itcast.core.controller.admin;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 上传图片
 * Created by Administrator on 2017/2/25.
 */
@Controller
public class UploadController {

    @RequestMapping(value = "/upload/uploadPic.do")
    public void uploadPic(@RequestParam(required = false) MultipartFile pic) {


        Client client = new Client();
        String url = "http://localhost:8180/upload/qqq.jpg";
        WebResource resource = client.resource(url);
        try {
            resource.put(String.class,pic.getBytes());
        }catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(pic.getOriginalFilename());
    }
}
