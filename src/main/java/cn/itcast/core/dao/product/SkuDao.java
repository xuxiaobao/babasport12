package cn.itcast.core.dao.product;

import cn.itcast.core.web.pojo.Sku;
import cn.itcast.core.web.pojo.WebParam;
import cn.itcast.core.web.pojo.WebResultMap;

import java.util.List;


public interface SkuDao {

	/**
	 * 添加
	 */
	public Integer addSku(WebParam map);

	/**
	 * 根据主键查找
	 */
	public Sku getSkuByKey(Integer id);

	/**
	 * 根据主键批量查找
	 */
	public List<Sku> getSkusByKeys(WebParam map);

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
	public Integer updateSkuByKey(WebParam map);

	/**
	 * 分页查询
	 */
	public List<Sku> getSkuListWithPage(WebParam map);

	/**
	 * 集合查询
	 */
	public List<Sku> getSkuList(WebParam map);

	/**
	 * 有库存的集合查询
	 */
	public List<Sku> getStock(WebParam map);
	/**
	 * 总条数
	 */
	public int getSkuListCount(WebParam map);

}
