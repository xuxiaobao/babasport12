package cn.itcast.core.service.product;

import cn.itcast.core.dao.product.FeatureDao;
import cn.itcast.core.web.pojo.WebParam;
import cn.itcast.core.web.pojo.WebResultMap;
import cn.itcast.page.Pagination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xxb on 2017/3/2.
 */
@Service
@Transactional
public class FeatureServiceImpl implements FeatureService {
   @Resource
   private FeatureDao featureDao;

    public Integer addFeature(WebParam map) {
        return null;
    }

    public WebResultMap getFeatureByKey(WebParam map) {
        return null;
    }

    public List<WebResultMap> getFeaturesByKeys(WebParam map) {
        return null;
    }

    public Integer deleteByKey(WebParam map) {
        return null;
    }

    public Integer deleteByKeys(WebParam map) {
        return null;
    }

    public Integer updateFeatureByKey(WebParam map) {
        return null;
    }

    public Pagination getFeatureListWithPage(WebParam map) {
        return null;
    }

    @Transactional(readOnly = true)
    public List<WebResultMap> getFeatureList(WebParam map) {
        return featureDao.getFeatureList(map);
    }

    public int getFeatureListCount(WebParam map) {
        return 0;
    }
}
