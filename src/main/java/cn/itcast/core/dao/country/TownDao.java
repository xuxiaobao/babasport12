package cn.itcast.core.dao.country;

import java.util.List;

import cn.itcast.core.web.pojo.WebParam;
import cn.itcast.core.web.pojo.WebResultMap;

public interface TownDao {

	/**
	 * 添加
	 */
	public Integer addTown(WebParam map);

	/**
	 * 根据主键查找
	 */
	public WebResultMap getTownByKey(WebParam map);

	/**
	 * 根据主键批量查找
	 */
	public List<WebResultMap> getTownsByKeys(WebParam map);

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
	public Integer updateTownByKey(WebParam map);

	/**
	 * 分页查询
	 */
	public List<WebResultMap> getTownListWithPage(WebParam map);

	/**
	 * 集合查询
	 */
	public List<WebResultMap> getTownList(WebParam map);
	
	/**
	 * 总条数
	 */
	public int getTownListCount(WebParam map);
}
