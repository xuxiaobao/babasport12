package cn.itcast.core.controller.admin;

import cn.itcast.core.controller.BaseController;
import cn.itcast.core.service.product.BrandService;
import cn.itcast.core.service.product.ProductService;
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

import java.util.List;

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
}
