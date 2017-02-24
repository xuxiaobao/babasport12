package cn.itcast.core.service.product;

import cn.itcast.page.Pagination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 品牌事务
 * Created by xxb on 2017/2/24.
 */
@Service
@Transactional
public class BrandServiceImpl {

    @Transactional(readOnly = true)
    public List<Map<String, Object>> getBrandListWithPage(Map<String, Object> map) {
        /*分页*/
        Pagination pagination = new Pagination();

        return null;
    }
}
