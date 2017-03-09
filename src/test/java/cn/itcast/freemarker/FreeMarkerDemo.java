package cn.itcast.freemarker;

import cn.itcast.Person;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

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

        Person p = new Person();
        p.setId(2);
        p.setName("新颖");
        root.put("p", p);

        List<String> persons = new ArrayList<String>();
        persons.add("person1");
        persons.add("person2");
        persons.add("person3");
        root.put("persons", persons);

        Map mx = new HashMap();
        mx.put("fbb", "范冰冰");
        mx.put("hzl", "郝子龙");
        root.put("mx", mx);

        root.put("curTime", new Date());
        Writer out = new FileWriter(new File(templeteDirectory + "hello.html"));
        template.process(root, out);
        out.flush();
        out.close();

        System.out.println("生成完成");
    }
}
