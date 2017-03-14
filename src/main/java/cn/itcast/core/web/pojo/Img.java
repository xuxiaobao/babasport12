package cn.itcast.core.web.pojo;

import cn.itcast.core.web.Constants;

/**
 * Created by Administrator on 2017/3/14.
 */
public class Img {
   private Integer id;
   private Integer productId;
   private String url;
   private Integer isDef;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getIsDef() {
        return isDef;
    }

    public void setIsDef(Integer isDef) {
        this.isDef = isDef;
    }

    public String getAllUrl() {
        return Constants.IMG_URL+url;
    }
}
