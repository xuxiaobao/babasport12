package cn.itcast.common.web;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 异步返回各种格式
 * json
 * xml
 * text
 * Created by Administrator on 2017/2/26.
 */
public class ResponseUtils {

    public static void render(HttpServletResponse response,String contendType,String text) {
        response.setContentType(contendType);
        try {
            response.getWriter().write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    发送json
     */
    public static void renderJson(HttpServletResponse response, String text) {
        render(response,"application/json;charset=UTF-8",text);
    }
    /*
    发送xml
     */
    public static void renderXml(HttpServletResponse response, String text) {
        render(response,"text/xml;charset=UTF-8",text);
    }
    /*
    发送text
     */
    public static void renderText(HttpServletResponse response, String text) {
        render(response, "text/plain;charset=UTF-8",text);
    }

}
