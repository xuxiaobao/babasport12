package cn.itcast.core.dao.product;

import java.util.List;
import java.util.Map;

/**
 * Created by xxb on 2017/2/23.
 */
public interface BrandDao {
    public List<Map<String, Object>> getBrandListWithPage(Map<String, Object> map);

    public int getBrandCount(Map<String, Object> map);
}
