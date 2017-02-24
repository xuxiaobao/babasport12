package cn.itcast.core.service.product;

import cn.itcast.core.web.pojo.WebParam;
import cn.itcast.page.Pagination;

/**
 * Created by xxb on 2017/2/24.
 */
public interface BrandService {
    public Pagination getBrandListWithPage(WebParam map);
}
