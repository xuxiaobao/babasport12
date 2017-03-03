package cn.itcast.core.service.product;

import cn.itcast.core.dao.product.ImgDao;
import cn.itcast.core.web.pojo.WebParam;
import cn.itcast.core.web.pojo.WebResultMap;
import cn.itcast.page.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xxb on 2017/3/3.
 */
@Service
@Transactional
public class ImgServiceImpl implements ImgService {

    @Autowired
    private ImgDao imgDao;
    public Integer addImg(WebParam map) {

        return imgDao.addImg(map);
    }

    public WebResultMap getImgByKey(WebParam map) {
        return null;
    }

    public List<WebResultMap> getImgsByKeys(WebParam map) {
        return null;
    }

    public Integer deleteByKey(WebParam map) {
        return null;
    }

    public Integer deleteByKeys(WebParam map) {
        return null;
    }

    public Integer updateImgByKey(WebParam map) {
        return null;
    }

    public Pagination getImgListWithPage(WebParam map) {
        return null;
    }

    public List<WebResultMap> getImgList(WebParam map) {
        return null;
    }

    public int getImgListCount(WebParam map) {
        return 0;
    }
}
