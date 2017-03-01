package cn.itcast.core.dao.order;

import java.util.List;

import cn.itcast.core.web.pojo.WebParam;
import cn.itcast.core.web.pojo.WebResultMap;

public interface OrderDao {

	/**
	 * 添加
	 */
	public Integer addOrder(WebParam map);

	/**
	 * 根据主键查找
	 */
	public WebResultMap getOrderByKey(WebParam map);

	/**
	 * 根据主键批量查找
	 */
	public List<WebResultMap> getOrdersByKeys(WebParam map);

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
	public Integer updateOrderByKey(WebParam map);

	/**
	 * 分页查询
	 */
	public List<WebResultMap> getOrderListWithPage(WebParam map);

	/**
	 * 集合查询
	 */
	public List<WebResultMap> getOrderList(WebParam map);
	
	/**
	 * 总条数
	 */
	public int getOrderListCount(WebParam map);
}
