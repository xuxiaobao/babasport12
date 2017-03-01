package cn.itcast.core.dao.user;

import cn.itcast.core.web.pojo.WebParam;
import cn.itcast.core.web.pojo.WebResultMap;

import java.util.List;


public interface AddrDao {

	/**
	 * 添加
	 */
	public Integer addAddr(WebParam map);

	/**
	 * 根据主键查找
	 */
	public WebResultMap getAddrByKey(WebParam map);

	/**
	 * 根据主键批量查找
	 */
	public List<WebResultMap> getAddrsByKeys(WebParam map);

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
	public Integer updateAddrByKey(WebParam map);

	/**
	 * 分页查询
	 */
	public List<WebResultMap> getAddrListWithPage(WebParam map);

	/**
	 * 集合查询
	 */
	public List<WebResultMap> getAddrList(WebParam map);
	
	/**
	 * 总条数
	 */
	public int getAddrListCount(WebParam map);
}
