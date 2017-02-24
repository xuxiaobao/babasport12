package cn.itcast.core.service.product;

import cn.itcast.core.dao.product.BrandDao;
import cn.itcast.core.web.pojo.WebParam;
import cn.itcast.page.Pagination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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
        Pagination pagination = new Pagination((Integer.parseInt(map.get("page").toString())-1)*5,Integer.parseInt(map.get("rows").toString()),brandDao.getBrandCount(map));
        pagination.setList(brandDao.getBrandListWithPage(map));
        return pagination;
    }
}
