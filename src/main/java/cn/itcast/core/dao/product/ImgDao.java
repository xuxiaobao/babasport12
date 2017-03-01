package cn.itcast.core.dao.product;

import cn.itcast.core.web.pojo.WebParam;
import cn.itcast.core.web.pojo.WebResultMap;

import java.util.List;


public interface ImgDao {

	/**
	 * 添加
	 */
	public Integer addImg(WebParam map);

	/**
	 * 根据主键查找
	 */
	public WebResultMap getImgByKey(WebParam map);

	/**
	 * 根据主键批量查找
	 */
	public List<WebResultMap> getImgsByKeys(WebParam map);

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
	public Integer updateImgByKey(WebParam map);

	/**
	 * 分页查询
	 */
	public List<WebResultMap> getImgListWithPage(WebParam map);

	/**
	 * 集合查询
	 */
	public List<WebResultMap> getImgList(WebParam map);
	
	/**
	 * 总条数
	 */
	public int getImgListCount(WebParam map);
}
