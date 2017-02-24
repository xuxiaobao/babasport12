package cn.itcast.core.dao.product;

import cn.itcast.core.web.pojo.WebParam;

import java.util.List;
import java.util.Map;

/**
 * Created by xxb on 2017/2/23.
 */
public interface BrandDao {
    public List<Map<String, Object>> getBrandListWithPage(WebParam map);

    public int getBrandCount(WebParam map);
}
