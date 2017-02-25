package cn.itcast.core.web.util;

import cn.itcast.core.web.pojo.WebParam;

/**
 * Created by Administrator on 2017/2/25.
 */
public class HrefParamUnion {
    public static StringBuilder paramsUnion(WebParam webParam,String ...args) {
        StringBuilder params = new StringBuilder("");
        for (int i=0;i<args.length;i++) {
            if (webParam.get(args[i]) != null && webParam.get(args[i]) != "") {
                params.append("&").append(args[i]).append("=").append(webParam.get(args[i]));
            }
        }
        if (params.length() > 0) {
            params.replace(0,1,"");
        }
        return params;
    }
}
