package cn.itcast.core.service.product;

import cn.itcast.core.dao.product.ProductDao;
import cn.itcast.core.web.pojo.WebParam;
import cn.itcast.core.web.pojo.WebResultMap;
import cn.itcast.page.Pagination;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/3/1.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductDao productDao;
    public Integer addProduct(WebParam map) {
        return null;
    }

    public WebResultMap getProductByKey(WebParam map) {
        return null;
    }

    public List<WebResultMap> getProductsByKeys(WebParam map) {
        return null;
    }

    public Integer deleteByKey(WebParam map) {
        return null;
    }

    public Integer deleteByKeys(WebParam map) {
        return null;
    }

    public Integer updateProductByKey(WebParam map) {
        return null;
    }

    @Transactional(readOnly = true)
    public Pagination getProductListWithPage(WebParam map) {
        /*分页*/
        Integer pageNo = Integer.parseInt(map.get("pageNo").toString());
        Integer pageSize = Integer.parseInt(map.get("pageSize").toString());
        PageHelper.startPage(pageNo,pageSize);
        List<WebResultMap> list = productDao.getProductListWithPage(map);
        PageInfo pageInfo = new PageInfo(list);
        Pagination pagination = new Pagination(pageNo,pageSize, (int) pageInfo.getTotal());
        pagination.setList(pageInfo.getList());

        return pagination;
    }

    public List<WebResultMap> getProductList(WebParam map) {
        return null;
    }

    public int getProductListCount(WebParam map) {
        return 0;
    }
}
