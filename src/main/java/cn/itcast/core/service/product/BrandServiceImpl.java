package cn.itcast.core.service.product;

import cn.itcast.core.dao.product.BrandDao;
import cn.itcast.core.web.pojo.WebParam;
import cn.itcast.page.Pagination;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 品牌事务
 * Created by xxb on 2017/2/24.
 */
@Service
@Transactional
public class BrandServiceImpl implements BrandService{

    @Resource
    private BrandDao brandDao;

    @Transactional(readOnly = true)
    public Pagination getBrandListWithPage(WebParam map) {
        /*分页*/
        Integer pageNo = Integer.parseInt(map.get("pageNo").toString());
        Integer pageSize = Integer.parseInt(map.get("pageSize").toString());
        PageHelper.startPage(pageNo,pageSize);
        List<Map<String, Object>> list = brandDao.getBrandListWithPage(map);
        PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
        Pagination pagination = new Pagination(pageNo,pageSize, (int) page.getTotal());
        pagination.setList(page.getList());
        return pagination;
    }
}
