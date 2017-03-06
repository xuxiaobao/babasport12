package cn.itcast.core.web.pojo;

import cn.itcast.core.web.Constants;

import java.util.HashMap;

/**
 * Created by xxb on 2017/3/6.
 */
public class ImgResultMap extends HashMap {
    @Override
    public Object get(Object key) {
        if ("allUrl".equals(key)) {
            return this.getAllUrl(key);
        }
        return super.get(key);
    }
    public Object getAllUrl(Object key) {
        return Constants.IMG_URL+this.get("url");
    }
}
