package cn.itcast.core.service.product;

import cn.itcast.core.dao.product.TypeDao;
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
public class TypeServiceImpl implements TypeService {

    @Resource
    private TypeDao typeDao;

    public Integer addType(WebParam map) {
        return null;
    }

    public WebResultMap getTypeByKey(WebParam map) {
        return null;
    }

    public List<WebResultMap> getTypesByKeys(WebParam map) {
        return null;
    }

    public Integer deleteByKey(WebParam map) {
        return null;
    }

    public Integer deleteByKeys(WebParam map) {
        return null;
    }

    public Integer updateTypeByKey(WebParam map) {
        return null;
    }

    public Pagination getTypeListWithPage(WebParam map) {
        return null;
    }

    @Transactional(readOnly = true)
    public List<WebResultMap> getTypeList(WebParam map) {
        return typeDao.getTypeList(map);
    }

    public int getTypeListCount(WebParam map) {
        return 0;
    }
}
