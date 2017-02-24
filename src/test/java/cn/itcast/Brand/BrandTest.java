package cn.itcast.Brand;

import cn.itcast.SpringJunitTest;
import cn.itcast.core.dao.product.BrandDao;
import cn.itcast.core.web.pojo.WebParam;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by xxb on 2017/2/24.
 */
public class BrandTest extends SpringJunitTest{
    @Resource
    private BrandDao brandDao;

    @Test
    public void testBrand() {
        WebParam map = new WebParam();
        map.put("isDisplay",1);
        List<Map<String, Object>> list = brandDao.getBrandListWithPage(map);
        System.out.println();
    }
}
