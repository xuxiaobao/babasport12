package cn.itcast.core.dao.order;

import java.util.List;

import cn.itcast.core.web.pojo.WebParam;
import cn.itcast.core.web.pojo.WebResultMap;

public interface DetailDao {

	/**
	 * 添加
	 */
	public Integer addDetail(WebParam map);

	/**
	 * 根据主键查找
	 */
	public WebResultMap getDetailByKey(WebParam map);

	/**
	 * 根据主键批量查找
	 */
	public List<WebResultMap> getDetailsByKeys(WebParam map);

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
	public Integer updateDetailByKey(WebParam map);

	/**
	 * 分页查询
	 */
	public List<WebResultMap> getDetailListWithPage(WebParam map);

	/**
	 * 集合查询
	 */
	public List<WebResultMap> getDetailList(WebParam map);
	
	/**
	 * 总条数
	 */
	public int getDetailListCount(WebParam map);
}
