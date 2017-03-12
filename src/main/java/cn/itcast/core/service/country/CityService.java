package cn.itcast.core.service.country;

import cn.itcast.core.web.pojo.WebParam;
import cn.itcast.core.web.pojo.WebResultMap;
import cn.itcast.page.Pagination;

import java.util.List;

/**
 * Created by Administrator on 2017/3/12.
 */
public interface CityService {
    /**
     * 添加
     */
    public Integer addCity(WebParam map);

    /**
     * 根据主键查找
     */
    public WebResultMap getCityByKey(WebParam map);

    /**
     * 根据主键批量查找
     */
    public List<WebResultMap> getCitysByKeys(WebParam map);

    /**
     * 根据主键删除
     */
    public Integer deleteByKey(WebParam map);

    /**
     * 根据主键批量删除
     */
    public Integer deleteByKeys(WebParam map);

    /**
     * 根据主键更新
     */
    public Integer updateCityByKey(WebParam map);

    /**
     * 分页查询
     */
    public Pagination getCityListWithPage(WebParam map);

    /**
     * 集合查询
     */
    public List<WebResultMap> getCityList(WebParam map);

    /**
     * 总条数
     */
    public int getCityListCount(WebParam map);
}
