package cn.itcast.core.service.product;

import cn.itcast.core.web.pojo.WebParam;
import cn.itcast.core.web.pojo.WebResultMap;
import cn.itcast.page.Pagination;

import java.util.List;

/**
 * Created by xxb on 2017/3/2.
 */
public interface TypeService {
    /**
     * 添加
     */
    public Integer addType(WebParam map);

    /**
     * 根据主键查找
     */
    public WebResultMap getTypeByKey(WebParam map);

    /**
     * 根据主键批量查找
     */
    public List<WebResultMap> getTypesByKeys(WebParam map);

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
    public Integer updateTypeByKey(WebParam map);

    /**
     * 分页查询
     */
    public Pagination getTypeListWithPage(WebParam map);

    /**
     * 集合查询
     */
    public List<WebResultMap> getTypeList(WebParam map);

    /**
     * 总条数
     */
    public int getTypeListCount(WebParam map);
}
