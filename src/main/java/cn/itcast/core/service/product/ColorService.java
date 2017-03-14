package cn.itcast.core.service.product;

import cn.itcast.core.web.pojo.Color;
import cn.itcast.core.web.pojo.WebParam;
import cn.itcast.core.web.pojo.WebResultMap;
import cn.itcast.page.Pagination;

import java.util.List;

/**
 * Created by xxb on 2017/3/2.
 */
public interface ColorService {
    /**
     * 添加
     */
    public Integer addColor(WebParam map);

    /**
     * 根据主键查找
     */
    public Color getColorByKey(WebParam map);

    /**
     * 根据主键批量查找
     */
    public List<Color> getColorsByKeys(WebParam map);

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
    public Integer updateColorByKey(WebParam map);

    /**
     * 分页查询
     */
    public Pagination getColorListWithPage(WebParam map);

    /**
     * 集合查询
     */
    public List<Color> getColorList(WebParam map);

    /**
     * 总条数
     */
    public int getColorListCount(WebParam map);
}
