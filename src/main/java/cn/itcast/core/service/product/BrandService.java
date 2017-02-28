package cn.itcast.core.service.product;

import cn.itcast.core.web.pojo.WebResultMap;
import cn.itcast.core.web.pojo.WebParam;
import cn.itcast.page.Pagination;

import java.util.List;

/**
 * Created by xxb on 2017/2/24.
 */
public interface BrandService {
    public Pagination getBrandListWithPage(WebParam map);

    public List<WebResultMap> getBrandList(WebParam map);

    public void addBrand(WebParam map);

    public int deleteBrandById(WebParam map);

    public int deleteBrandByIds(WebParam map);

    public int updateBrandByKey(WebParam map);

    public WebResultMap getBrandById(WebParam map);
}
