package cn.itcast.core.dao.product;

import java.util.List;

import cn.itcast.core.web.pojo.WebParam;
import cn.itcast.core.web.pojo.WebResultMap;

public interface TypeDao {

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
	public List<WebResultMap> getTypeListWithPage(WebParam map);

	/**
	 * 集合查询
	 */
	public List<WebResultMap> getTypeList(WebParam map);
	
	/**
	 * 总条数
	 */
	public int getTypeListCount(WebParam map);
}
