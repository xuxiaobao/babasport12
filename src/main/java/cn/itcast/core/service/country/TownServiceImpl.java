package cn.itcast.core.service.country;

import cn.itcast.core.dao.country.TownDao;
import cn.itcast.core.web.pojo.WebParam;
import cn.itcast.core.web.pojo.WebResultMap;
import cn.itcast.page.Pagination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/3/12.
 */
@Service
@Transactional
public class TownServiceImpl implements TownService {
    @Resource
    private TownDao townDao;

    public Integer addTown(WebParam map) {
        return null;
    }

    public WebResultMap getTownByKey(WebParam map) {
        return null;
    }

    public List<WebResultMap> getTownsByKeys(WebParam map) {
        return null;
    }

    public Integer deleteByKey(WebParam map) {
        return null;
    }

    public Integer deleteByKeys(WebParam map) {
        return null;
    }

    public Integer updateTownByKey(WebParam map) {
        return null;
    }

    public Pagination getTownListWithPage(WebParam map) {
        return null;
    }

    @Transactional(readOnly = true)
    public List<WebResultMap> getTownList(WebParam map) {
        return townDao.getTownList(map);
    }

    public int getTownListCount(WebParam map) {
        return 0;
    }
}
