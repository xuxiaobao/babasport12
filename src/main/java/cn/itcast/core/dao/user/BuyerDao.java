package cn.itcast.core.dao.user;

import cn.itcast.core.web.pojo.WebParam;
import cn.itcast.core.web.pojo.WebResultMap;

import java.util.List;


public interface BuyerDao {

	/**
	 * 添加
	 */
	public Integer addBuyer(WebParam map);

	/**
	 * 根据主键查找
	 */
	public WebResultMap getBuyerByKey(WebParam map);

	/**
	 * 根据主键批量查找
	 */
	public List<WebResultMap> getBuyersByKeys(WebParam map);

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
	public Integer updateBuyerByKey(WebParam map);

	/**
	 * 分页查询
	 */
	public List<WebResultMap> getBuyerListWithPage(WebParam map);

	/**
	 * 集合查询
	 */
	public List<WebResultMap> getBuyerList(WebParam map);
	
	/**
	 * 总条数
	 */
	public int getBuyerListCount(WebParam map);
}
