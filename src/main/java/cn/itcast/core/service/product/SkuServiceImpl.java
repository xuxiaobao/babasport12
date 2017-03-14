package cn.itcast.core.service.product;

import cn.itcast.core.dao.product.SkuDao;
import cn.itcast.core.web.pojo.*;
import cn.itcast.page.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xxb on 2017/3/3.
 */
@Service
@Transactional
public class SkuServiceImpl implements SkuService {

    @Resource
    private SkuDao skuDao;
    @Resource
    private ImgService imgService;
    @Resource
    private ColorService colorService;
    @Resource
    private ProductService productService;

    public Integer addSku(WebParam map) {
        return skuDao.addSku(map);
    }

    @Transactional(readOnly = true)
    public Sku getSkuByKey(Integer id) {
        Sku sku = skuDao.getSkuByKey(id);
        WebParam productParam = new WebParam();
        productParam.put("id", sku.getProductId());
        Product product = productService.getProductByKey(productParam);
        sku.setProduct(product);

        WebParam colorParam = new WebParam();
        colorParam.put("id",sku.getColorId());
        Color color = colorService.getColorByKey(colorParam);
        sku.setColor(color);
        return sku;
    }

    public List<Sku> getSkusByKeys(WebParam map) {
        return null;
    }

    public Integer deleteByKey(WebParam map) {
        return null;
    }

    public Integer deleteByKeys(WebParam map) {
        return null;
    }

    public Integer updateSkuByKey(WebParam map) {
        return skuDao.updateSkuByKey(map);
    }

    public Pagination getSkuListWithPage(WebParam map) {
        return null;
    }

    @Transactional(readOnly = true)
    public List<Sku> getSkuList(WebParam map) {
        List<Sku> skuList = skuDao.getSkuList(map);
        for (Sku sku : skuList) {
            WebParam colorParam = new WebParam();
            colorParam.put("id",sku.getColorId());
            Color color = colorService.getColorByKey(colorParam);
            sku.setColor(color);
        }
        return skuList;
    }

    public List<Sku> getStock(WebParam map) {
        List<Sku> skuList = skuDao.getStock(map);
        for (Sku sku : skuList) {
            WebParam colorParam = new WebParam();
            colorParam.put("id",sku.getColorId());
            Color color = colorService.getColorByKey(colorParam);
            sku.setColor(color);
        }
        return skuList;
    }

    public int getSkuListCount(WebParam map) {
        return 0;
    }
}
