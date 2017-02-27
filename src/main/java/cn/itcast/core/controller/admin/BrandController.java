package cn.itcast.core.controller.admin;

import cn.itcast.core.controller.BaseController;
import cn.itcast.core.service.product.BrandService;
import cn.itcast.core.web.pojo.WebParam;
import cn.itcast.core.web.util.HrefParamUnion;
import cn.itcast.page.Pagination;
import cn.itcast.validator.Validators;
import cn.itcast.validator.annotation.Params;
import cn.itcast.validator.annotation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 品牌
 * Created by xxb on 2017/2/24.
 */
@Controller
@RequestMapping(value = "/brand")
public class BrandController extends BaseController{

    @Autowired
    private BrandService brandService;

    @RequestMapping(value = "/toAdd.do")
    public String toAdd() {

        return "brand/add";
    }

    @Valid(value = {
            @Params(name = "isDisplay", type = Integer.class, validator = Validators.NONE),
            @Params(name = "name", type = String.class,validator = Validators.NONE),
            @Params(name = "pageNo", type = Integer.class, validator = Validators.NONE),
            @Params(name = "pageSize", type = Integer.class, validator = Validators.NONE)
    })
    @RequestMapping(value = "/list.do")
    public String brandList(ModelMap model) {
        StringBuilder params = new StringBuilder();
        WebParam webParam = getWebParam();
        /*设置分页参数*/
        initPagination();
        Pagination pagination = brandService.getBrandListWithPage(webParam);
        params = HrefParamUnion.paramsUnion(webParam,"name","isDisplay");
        pagination.pageView("/brand/list.do",params.toString());
        model.addAttribute("pagination",pagination);
        model.addAttribute("pams",webParam);
        return "brand/list";
    }

    @Valid({
            @Params(name = "name", type = String.class, validator = Validators.COMMON.REQUIRED),
            @Params(name = "imgUrl", type = String.class, validator = Validators.COMMON.REQUIRED),
            @Params(name = "description", type = String.class, validator = Validators.NONE,maxLength = "80"),
            @Params(name = "sort", type = Integer.class, validator = Validators.NONE),
            @Params(name = "isDisplay", type = Integer.class, validator = Validators.NONE)
    })
    @RequestMapping(value = "/add.do")
    public String add() {
        WebParam webParam = getWebParam();
        brandService.addBrand(webParam);

        return "brand/list";
    }

    @Valid({
            @Params(name = "name", type = String.class, validator = Validators.NONE),
            @Params(name = "isDisplay", type = Integer.class, validator = Validators.NONE),
            @Params(name = "id", type = Integer.class, validator = Validators.COMMON.REQUIRED)
    })
    @RequestMapping(value = "/deleteById.do")
    public String deleteBrandById(ModelMap model) {
        WebParam webParam = getWebParam();
        if (webParam.get("name") != null) {
            model.addAttribute("name",webParam.get("name"));
        }
        if (webParam.get("isDisplay") != null) {
            model.addAttribute("isDisplay",webParam.get("isDisplay"));
        }
        brandService.deleteBrandById(webParam);
        return "redirect:/brand/list.do";
    }

}
