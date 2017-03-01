package cn.itcast.core.dao.country;

import cn.itcast.core.web.pojo.WebParam;
import cn.itcast.core.web.pojo.WebResultMap;

import java.util.List;

public interface ProvinceDao {

	/**
	 * 添加
	 */
	public Integer addProvince(WebParam map);

	/**
	 * 根据主键查找
	 */
	public WebResultMap getProvinceByKey(WebParam map);

	/**
	 * 根据主键批量查找
	 */
	public List<WebResultMap> getProvincesByKeys(WebParam map);

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
	public Integer updateProvinceByKey(WebParam map);

	/**
	 * 分页查询
	 */
	public List<WebResultMap> getProvinceListWithPage(WebParam map);

	/**
	 * 集合查询
	 */
	public List<WebResultMap> getProvinceList(WebParam map);
	
	/**
	 * 总条数
	 */
	public int getProvinceListCount(WebParam map);
}
