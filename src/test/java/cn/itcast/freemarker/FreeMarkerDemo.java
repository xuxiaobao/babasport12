package cn.itcast.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xxb on 2017/3/8.
 */
public class FreeMarkerDemo {

    public static void main(String[] args) throws IOException, TemplateException {
        Configuration conf = new Configuration();
        String templeteDirectory = "D:\\myself_workspace\\babasport12\\src\\main\\webapp\\WEB-INF\\ftl\\";
        conf.setDirectoryForTemplateLoading(new File(templeteDirectory));
        Template template = conf.getTemplate("freemarker.html");
        Map root = new HashMap();
        root.put("world", null);
        Writer out = new FileWriter(new File(templeteDirectory + "hello.html"));
        template.process(root, out);
        out.flush();
        out.close();
    }
}
