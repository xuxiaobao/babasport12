package cn.itcast.core.dao.product;

import cn.itcast.core.web.pojo.WebResultMap;
import cn.itcast.core.web.pojo.WebParam;

import java.util.List;

/**
 * Created by xxb on 2017/2/23.
 */
public interface BrandDao {
    public List<WebResultMap> getBrandListWithPage(WebParam map);

    public List<WebResultMap> getBrandList(WebParam map);

    public int getBrandCount(WebParam map);

    public int addBrand(WebParam map);

    public int deleteBrandById(WebParam map);

    public int deleteBrandByIds(WebParam map);

    public int updateBrandByKey(WebParam map);

    public WebResultMap getBrandById(WebParam map);
}
