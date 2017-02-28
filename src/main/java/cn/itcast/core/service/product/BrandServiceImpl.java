package cn.itcast.core.service.product;

import cn.itcast.core.dao.product.BrandDao;
import cn.itcast.core.web.pojo.WebResultMap;
import cn.itcast.core.web.pojo.WebParam;
import cn.itcast.page.Pagination;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 品牌事务
 * Created by xxb on 2017/2/24.
 */
@Service
@Transactional
public class BrandServiceImpl implements BrandService{

    @Resource
    private BrandDao brandDao;

    @Transactional(readOnly = true)
    public Pagination getBrandListWithPage(WebParam map) {
        /*分页*/
        Integer pageNo = Integer.parseInt(map.get("pageNo").toString());
        Integer pageSize = Integer.parseInt(map.get("pageSize").toString());
        PageHelper.startPage(pageNo,pageSize);
        List<WebResultMap> list = brandDao.getBrandListWithPage(map);
        PageInfo<WebResultMap> page = new PageInfo<WebResultMap>(list);
        Pagination pagination = new Pagination(pageNo,pageSize, (int) page.getTotal());
        pagination.setList(page.getList());
        return pagination;
    }

    @Transactional(readOnly = true)
    public List<WebResultMap> getBrandList(WebParam map) {
        return brandDao.getBrandList(map);
    }

    public void addBrand(WebParam map) {
        brandDao.addBrand(map);
    }

    public int deleteBrandById(WebParam map) {

        return brandDao.deleteBrandById(map);
    }

    public int deleteBrandByIds(WebParam map) {
        return brandDao.deleteBrandByIds(map);
    }

    public int updateBrandByKey(WebParam map) {

        return brandDao.updateBrandByKey(map);
    }

    @Transactional(readOnly = true)
    public WebResultMap getBrandById(WebParam map) {
        WebResultMap brand = brandDao.getBrandById(map);
        /*brand.put("allUrl", Constants.IMG_URL+brand.get("imgUrl"));*/
        return brand;
    }

}
