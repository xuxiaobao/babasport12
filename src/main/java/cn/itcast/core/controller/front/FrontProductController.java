package cn.itcast.core.controller.front;

import cn.itcast.core.controller.BaseController;
import cn.itcast.core.service.product.BrandService;
import cn.itcast.core.service.product.FeatureService;
import cn.itcast.core.service.product.ProductService;
import cn.itcast.core.service.product.TypeService;
import cn.itcast.core.web.pojo.WebParam;
import cn.itcast.core.web.pojo.WebResultMap;
import cn.itcast.core.web.util.HrefParamUnion;
import cn.itcast.page.Pagination;
import cn.itcast.validator.annotation.Params;
import cn.itcast.validator.annotation.Valid;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 前台商品列表
 * Created by xxb on 2017/3/6.
 */
@Controller
public class FrontProductController extends BaseController{

    @Autowired
    private TypeService typeService;
    @Autowired
    private FeatureService featureService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private ProductService productService;

    @Valid({
            @Params(name = "pageNo", type = Integer.class),
            @Params(name = "brandId",type = Integer.class),
            @Params(name = "brandName", type = String.class),
            @Params(name = "typeId", type = Integer.class),
            @Params(name = "typeName", type = String.class),
            @Params(name = "featuresId", type = Integer.class),
            @Params(name = "featuresName", type = String.class),
    })
    @RequestMapping(value = "/product/display/list.shtml")
    public String list(ModelMap model) {
        WebParam webParam = getWebParam();
        webParam.put("pageSize",8);
        boolean flag = false;
        Map<Object, Object> query = new HashMap<Object, Object>();
        StringBuilder params = new StringBuilder();
        //加载品牌列表
        if (webParam.get("brandId") != null) {
            flag = true;
            query.put("品牌",webParam.get("brandName"));
            params = HrefParamUnion.paramsUnion(webParam,"brandId","brandName");
        } else {
            WebParam brandParam = new WebParam();
            brandParam.put("fields","id,name");
            brandParam.put("idDisplay",1);
            List<WebResultMap> brands = brandService.getBrandList(brandParam);
            model.addAttribute("brands",brands);
        }
        //加载商品类型
        if (webParam.get("typeId") != null) {
            flag = true;
            query.put("类型",webParam.get("typeName"));
            params = HrefParamUnion.paramsUnion(webParam,"typeId","typeName");
        }else {
            WebParam typeParam = new WebParam();
            typeParam.put("fields","id,name");
            typeParam.put("isDisplay",1);
            typeParam.put("parentId",0);
            List<WebResultMap> types = typeService.getTypeList(typeParam);
            model.addAttribute("types",types);
        }

        //加载商品属性
        if (webParam.get("featuresId") != null) {
            flag = true;
            query.put("材质",webParam.get("featuresName"));
            params = HrefParamUnion.paramsUnion(webParam,"featuresId","featuresName");
        } else {
            WebParam featureParam = new WebParam();
            featureParam.put("fields","id,name");
            featureParam.put("isDel",1);
            List<WebResultMap> features = featureService.getFeatureList(featureParam);
            model.addAttribute("features",features);
        }

        Pagination pagination = productService.getProductListWithPage(webParam);
        pagination.pageView("/product/display/list.shtml",params.toString());
        model.addAttribute("pagination",pagination);
        model.addAttribute("pams",webParam);
        model.addAttribute("flag", flag);
        model.addAttribute("query",query);
        return "product/product";
    }
}
