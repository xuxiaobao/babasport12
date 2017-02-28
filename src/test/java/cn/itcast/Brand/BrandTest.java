package cn.itcast.Brand;

import cn.itcast.SpringJunitTest;
import cn.itcast.core.dao.product.BrandDao;
import cn.itcast.core.web.pojo.WebResultMap;
import cn.itcast.core.web.pojo.WebParam;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xxb on 2017/2/24.
 */
public class BrandTest extends SpringJunitTest{
    @Resource
    private BrandDao brandDao;

    @Test
    public void testBrand() {
        WebParam map = new WebParam();
        map.put("fields","id");
        List<WebResultMap> list = brandDao.getBrandList(map);
        System.out.println(list);
    }
}
