package cn.itcast.core.service.product;

import cn.itcast.core.dao.product.SkuDao;
import cn.itcast.core.web.pojo.WebParam;
import cn.itcast.core.web.pojo.WebResultMap;
import cn.itcast.page.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xxb on 2017/3/3.
 */
@Service
@Transactional
public class SkuServiceImpl implements SkuService {

    @Autowired
    private SkuDao skuDao;

    public Integer addSku(WebParam map) {
        return skuDao.addSku(map);
    }

    public WebResultMap getSkuByKey(WebParam map) {
        return null;
    }

    public List<WebResultMap> getSkusByKeys(WebParam map) {
        return null;
    }

    public Integer deleteByKey(WebParam map) {
        return null;
    }

    public Integer deleteByKeys(WebParam map) {
        return null;
    }

    public Integer updateSkuByKey(WebParam map) {
        return null;
    }

    public Pagination getSkuListWithPage(WebParam map) {
        return null;
    }

    public List<WebResultMap> getSkuList(WebParam map) {
        return null;
    }

    public int getSkuListCount(WebParam map) {
        return 0;
    }
}
