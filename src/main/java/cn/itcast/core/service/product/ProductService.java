package cn.itcast.core.service.product;

import cn.itcast.core.web.pojo.WebParam;
import cn.itcast.core.web.pojo.WebResultMap;
import cn.itcast.page.Pagination;

import java.util.List;

/**
 * Created by Administrator on 2017/3/1.
 */
public interface ProductService {
    /**
     * 添加
     */
    public Integer addProduct(WebParam map);

    /**
     * 根据主键查找
     */
    public WebResultMap getProductByKey(WebParam map);

    /**
     * 根据主键批量查找
     */
    public List<WebResultMap> getProductsByKeys(WebParam map);

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
    public Integer updateProductByKey(WebParam map);

    /**
     * 分页查询
     */
    public Pagination getProductListWithPage(WebParam map);

    /**
     * 集合查询
     */
    public List<WebResultMap> getProductList(WebParam map);

    /**
     * 总条数
     */
    public int getProductListCount(WebParam map);
}
