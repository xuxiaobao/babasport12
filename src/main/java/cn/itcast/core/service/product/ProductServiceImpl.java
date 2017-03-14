package cn.itcast.core.service.product;

import cn.itcast.core.dao.product.ProductDao;
import cn.itcast.core.web.pojo.*;
import cn.itcast.page.Pagination;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.deploy.util.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/1.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductDao productDao;
    @Resource
    private ImgService imgService;
    @Resource
    private SkuService skuService;

    public Integer addProduct(WebParam map) {
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String no = df.format(new Date());
        map.put("no", no);
        map.put("createTime", new Date());
        map.put("productSize", StringUtils.join((ArrayList<String>)map.get("productSize"),","));
        map.put("color",StringUtils.join((ArrayList<Integer>)map.get("color"),","));
        map.put("feature",StringUtils.join((ArrayList<Integer>)map.get("feature"),","));
        //插入商品
        Integer productR = productDao.addProduct(map);
        //插入图片
        WebParam imgParam = new WebParam();
        imgParam.put("url",map.get("imgUrl"));
        imgParam.put("productId",map.get("id"));
        imgParam.put("isDef",1);
        imgService.addImg(imgParam);
        //保存sku
        WebParam skuParam = new WebParam();
        //商品ID
        skuParam.put("productId",map.get("id"));
        //运费
        skuParam.put("deliveFee",10.00);
        //售价
        skuParam.put("skuPrice",0.00);
        //市场价
        skuParam.put("marketPrice",0.00);
        //库存
        skuParam.put("stockInventory",0);
        //购买限制
        skuParam.put("skuUpperLimit",0);
        //增加时间
        skuParam.put("createTime",new Date());
        //是否最新
        skuParam.put("lastStatus",1);
        //商品类型
        skuParam.put("skuType", 1);
        //销量
        skuParam.put("sales", 0);
        for (String color : map.get("color").toString().split(",")) {
            skuParam.put("colorId",Integer.parseInt(color));
            for (String size : map.get("productSize").toString().split(",")) {
                skuParam.put("skuSize",size);
                skuService.addSku(skuParam);
            }
        }

        return productR;
    }

    @Transactional(readOnly = true)
    public Product getProductByKey(WebParam map) {
        Product product = productDao.getProductByKey(map);
        WebParam imgParam = new WebParam();
        imgParam.put("productId", product.getId());
        imgParam.put("isDef", 1);
        List<Img> imgList = imgService.getImgList(imgParam);
        if (imgList != null && imgList.size() > 0) {
            product.setImg(imgList.get(0));
        }
        return product;
    }

    public List<Product> getProductsByKeys(WebParam map) {
        return null;
    }

    public Integer deleteByKey(WebParam map) {
        return null;
    }

    public Integer deleteByKeys(WebParam map) {
        return null;
    }

    public Integer updateProductByKey(WebParam map) {
        return productDao.updateProductByKey(map);
    }

    @Transactional(readOnly = true)
    public Pagination getProductListWithPage(WebParam map) {
        /*分页*/
        Integer pageNo = Integer.parseInt(map.get("pageNo").toString());
        Integer pageSize = Integer.parseInt(map.get("pageSize").toString());
        PageHelper.startPage(pageNo,pageSize);
        List<Product> list = productDao.getProductListWithPage(map);
        for (Product product : list) {
            WebParam imgParam = new WebParam();
            imgParam.put("productId",product.getId());
            List<Img> imgList = imgService.getImgList(imgParam);
            if (imgList != null && imgList.size() > 0) {
                product.setImg(imgList.get(0));
            }
        }
        PageInfo pageInfo = new PageInfo(list);
        Pagination pagination = new Pagination(pageNo,pageSize, (int) pageInfo.getTotal());
        pagination.setList(pageInfo.getList());
        return pagination;
    }

    public List<Product> getProductList(WebParam map) {
        return null;
    }

    public int getProductListCount(WebParam map) {
        return 0;
    }

}
