package cn.itcast.core.service.product;

import cn.itcast.core.dao.product.ColorDao;
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
public class ColorServiceImpl implements ColorService {
    @Resource
    private ColorDao colorDao;

    public Integer addColor(WebParam map) {
        return null;
    }

    public WebResultMap getColorByKey(WebParam map) {
        return colorDao.getColorByKey(map);
    }

    public List<WebResultMap> getColorsByKeys(WebParam map) {
        return null;
    }

    public Integer deleteByKey(WebParam map) {
        return null;
    }

    public Integer deleteByKeys(WebParam map) {
        return null;
    }

    public Integer updateColorByKey(WebParam map) {
        return null;
    }

    public Pagination getColorListWithPage(WebParam map) {
        return null;
    }

    @Transactional(readOnly = true)
    public List<WebResultMap> getColorList(WebParam map) {
        return colorDao.getColorList(map);
    }

    public int getColorListCount(WebParam map) {
        return 0;
    }
}
