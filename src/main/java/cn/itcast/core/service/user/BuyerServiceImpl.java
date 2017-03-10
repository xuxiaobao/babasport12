package cn.itcast.core.service.user;

import cn.itcast.core.dao.user.BuyerDao;
import cn.itcast.core.web.pojo.WebParam;
import cn.itcast.core.web.pojo.WebResultMap;
import cn.itcast.page.Pagination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xxb on 2017/3/10.
 */
@Service
@Transactional
public class BuyerServiceImpl implements BuyerService {
    @Resource
    private BuyerDao buyerDao;
    public Integer addBuyer(WebParam map) {
        return null;
    }

    @Transactional(readOnly = true)
    public WebResultMap getBuyerByKey(WebParam map) {
        return buyerDao.getBuyerByKey(map);
    }

    public List<WebResultMap> getBuyersByKeys(WebParam map) {
        return null;
    }

    public Integer deleteByKey(WebParam map) {
        return null;
    }

    public Integer deleteByKeys(WebParam map) {
        return null;
    }

    public Integer updateBuyerByKey(WebParam map) {
        return null;
    }

    public Pagination getBuyerListWithPage(WebParam map) {
        return null;
    }

    public List<WebResultMap> getBuyerList(WebParam map) {
        return null;
    }

    public int getBuyerListCount(WebParam map) {
        return 0;
    }
}
