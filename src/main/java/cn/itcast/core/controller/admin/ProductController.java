package cn.itcast.core.controller.admin;

import cn.itcast.core.controller.BaseController;
import cn.itcast.core.service.product.*;
import cn.itcast.core.web.pojo.WebParam;
import cn.itcast.core.web.pojo.WebResultMap;
import cn.itcast.core.web.util.HrefParamUnion;
import cn.itcast.page.Pagination;
import cn.itcast.validator.Validators;
import cn.itcast.validator.annotation.Params;
import cn.itcast.validator.annotation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 后台商品管理
 * 商品列表
 * 商品添加
 * 商品上架
 * Created by xxb on 2017/2/23.
 */
@Controller
@RequestMapping("/product")
public class ProductController extends BaseController{

    @Autowired
    private BrandService brandService;
    @Autowired
    private ProductService productService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private FeatureService featureService;
    @Autowired
    private ColorService colorService;

    @Valid({
            @Params(name = "pageNo", type = Integer.class, validator = Validators.NONE),
            @Params(name = "name", type = String.class, validator = Validators.NONE),
            @Params(name = "brandId", type = Integer.class, validator = Validators.NONE),
            @Params(name = "isShow", type = Integer.class, validator = Validators.NONE),
    })
    @RequestMapping("/list.do")
    public String productList(ModelMap model) {
        WebParam brandParams = new WebParam();
        brandParams.put("fields","id,name");
        brandParams.put("isDisplay",1);
        List<WebResultMap> brands = brandService.getBrandList(brandParams);
        model.addAttribute("brands",brands);
        WebParam webParam = getWebParam();
        /*设置分页参数*/
        initPagination();
        webParam.put("nameLike",true);
        /*webParam.put("fields","id,no,name,")*/
        Pagination pagination = productService.getProductListWithPage(webParam);
        StringBuilder params = new StringBuilder();
        params = HrefParamUnion.paramsUnion(webParam,"name","brandId","isShow");
        pagination.pageView("/product/list.do",params.toString());
        model.addAttribute("pagination",pagination);
        model.addAttribute("pams",webParam);
        return "product/list";
    }

    @RequestMapping(value = "/toAdd.do")
    public String toAdd(ModelMap model) {
        //加载商品类型
        WebParam typeParam = new WebParam();
        typeParam.put("fields","id,name");
        typeParam.put("isDisplay",1);
        typeParam.put("parentId",0);
        List<WebResultMap> types = typeService.getTypeList(typeParam);
        model.addAttribute("types",types);
        //加载商品属性
        WebParam featureParam = new WebParam();
        featureParam.put("fields","id,name");
        featureParam.put("isDel",1);
        List<WebResultMap> features = featureService.getFeatureList(featureParam);
        model.addAttribute("features",features);
        //加载品牌列表
        WebParam brandParam = new WebParam();
        brandParam.put("fields","id,name");
        brandParam.put("idDisplay",1);
        List<WebResultMap> brands = brandService.getBrandList(brandParam);
        model.addAttribute("brands",brands);
        //加载颜色大全
        WebParam colorParam = new WebParam();
        colorParam.put("fields","id,name");
        List<WebResultMap> colors = colorService.getColorList(colorParam);
        model.addAttribute("colors",colors);
        return "product/add";
    }

    @Valid({
            @Params(name = "typeId", type = Integer.class, validator = Validators.COMMON.REQUIRED),
            @Params(name = "name", type = String.class, validator = Validators.COMMON.REQUIRED),
            @Params(name = "brandId", type = Integer.class, validator = Validators.COMMON.REQUIRED),
            @Params(name = "weight", type = Double.class, validator = Validators.COMMON.REQUIRED),
            @Params(name = "feature", type = ArrayList.class, elementType = Integer.class, validator = Validators.COMMON.REQUIRED),
            @Params(name = "color", type = ArrayList.class, elementType = Integer.class,validator = Validators.COMMON.REQUIRED),
            @Params(name = "productSize", type = ArrayList.class, elementType = String.class, validator = Validators.COMMON.REQUIRED),
            @Params(name = "isNew", type = Integer.class, validator = Validators.COMMON.REQUIRED),
            @Params(name = "isCommend", type = Integer.class, validator = Validators.COMMON.REQUIRED),
            @Params(name = "isHot", type = Integer.class, validator = Validators.COMMON.REQUIRED),
            @Params(name = "imgUrl", type = String.class, validator = Validators.COMMON.REQUIRED),
            @Params(name = "description", type = String.class, validator = Validators.COMMON.REQUIRED),
            @Params(name = "packageList", type = String.class, validator = Validators.COMMON.REQUIRED),
    })
    @RequestMapping("/add.do")
    public void add(HttpServletRequest request) {
        WebParam webParam = getWebParam();
        productService.addProduct(webParam);
    }
}
