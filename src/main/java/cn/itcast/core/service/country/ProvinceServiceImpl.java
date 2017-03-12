package cn.itcast.core.service.country;

import cn.itcast.core.dao.country.ProvinceDao;
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
public class ProvinceServiceImpl implements ProvinceService{
    @Resource
    private ProvinceDao provinceDao;

    public Integer addProvince(WebParam map) {
        return null;
    }

    public WebResultMap getProvinceByKey(WebParam map) {
        return null;
    }

    public List<WebResultMap> getProvincesByKeys(WebParam map) {
        return null;
    }

    public Integer deleteByKey(WebParam map) {
        return null;
    }

    public Integer deleteByKeys(WebParam map) {
        return null;
    }

    public Integer updateProvinceByKey(WebParam map) {
        return null;
    }

    public Pagination getProvinceListWithPage(WebParam map) {
        return null;
    }

    @Transactional(readOnly = true)
    public List<WebResultMap> getProvinceList(WebParam map) {
        return provinceDao.getProvinceList(map);
    }

    public int getProvinceListCount(WebParam map) {
        return 0;
    }
}
