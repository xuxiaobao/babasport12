package cn.itcast.core.service.country;

import cn.itcast.core.dao.country.CityDao;
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
public class CityServiceImpl implements CityService {
    @Resource
    private CityDao cityDao;
    public Integer addCity(WebParam map) {
        return null;
    }

    public WebResultMap getCityByKey(WebParam map) {
        return null;
    }

    public List<WebResultMap> getCitysByKeys(WebParam map) {
        return null;
    }

    public Integer deleteByKey(WebParam map) {
        return null;
    }

    public Integer deleteByKeys(WebParam map) {
        return null;
    }

    public Integer updateCityByKey(WebParam map) {
        return null;
    }

    public Pagination getCityListWithPage(WebParam map) {
        return null;
    }

    @Transactional(readOnly = true)
    public List<WebResultMap> getCityList(WebParam map) {
        return cityDao.getCityList(map);
    }

    public int getCityListCount(WebParam map) {
        return 0;
    }
}
