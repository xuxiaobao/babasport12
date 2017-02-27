package cn.itcast.core.controller.admin;

import cn.itcast.common.web.ResponseUtils;
import cn.itcast.core.web.Constants;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 上传图片
 * Created by Administrator on 2017/2/25.
 */
@Controller
public class UploadController {

    @RequestMapping(value = "/upload/uploadPic.do")
    public void uploadPic(@RequestParam(required = false) MultipartFile pic, HttpServletResponse response) {
        String ext = FilenameUtils.getExtension(pic.getOriginalFilename());
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String format = df.format(new Date());
        Random r = new Random();
        format += r.nextInt(1000);
        Client client = new Client();
        StringBuilder sb = new StringBuilder();
        String path = sb.append("upload/").append(format).append(".").append(ext).toString();
        String url = Constants.IMG_URL+path;
        WebResource resource = client.resource(url);
        try {
            resource.put(String.class,pic.getBytes());
        }catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject jo = new JSONObject();
        jo.put("url",url);
        jo.put("path",path);
        ResponseUtils.renderJson(response,jo.toString());
    }
}
