package cn.itcast.core.dao.user;

import java.util.List;

import cn.itcast.core.web.pojo.WebParam;
import cn.itcast.core.web.pojo.WebResultMap;

public interface EmployeeDao {

	/**
	 * 添加
	 */
	public Integer addEmployee(WebParam map);

	/**
	 * 根据主键查找
	 */
	public WebResultMap getEmployeeByKey(WebParam map);

	/**
	 * 根据主键批量查找
	 */
	public List<WebResultMap> getEmployeesByKeys(WebParam map);

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
	public Integer updateEmployeeByKey(WebParam map);

	/**
	 * 分页查询
	 */
	public List<WebResultMap> getEmployeeListWithPage(WebParam map);

	/**
	 * 集合查询
	 */
	public List<WebResultMap> getEmployeeList(WebParam map);
	
	/**
	 * 总条数
	 */
	public int getEmployeeListCount(WebParam map);
}
