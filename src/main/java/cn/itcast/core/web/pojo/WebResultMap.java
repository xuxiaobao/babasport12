package cn.itcast.core.web.pojo;

import cn.itcast.core.web.Constants;

import java.util.HashMap;

/**
 * Created by xxb on 2017/2/28.
 */
public class WebResultMap extends HashMap<Object, Object> {

    @Override
    public Object get(Object key) {

        if ("allUrl".equals(key)) {
            return getAllUrl(key);
        }

        return super.get(key);
    }

    public String getAllUrl(Object key) {
        return Constants.IMG_URL+this.get("imgUrl");
    }

}
