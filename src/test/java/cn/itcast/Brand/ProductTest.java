package cn.itcast.Brand;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

/**
 * Created by xxb on 2017/3/3.
 */
public class ProductTest {
    public static void main(String[] arsg) {
        ArrayList<String> array = new ArrayList<String>();
        array.add("1");
        array.add("2");
        array.add("3");
        array.add("4");
        System.out.println(StringUtils.join(array,","));
    }

}
