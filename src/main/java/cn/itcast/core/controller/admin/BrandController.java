package cn.itcast.core.controller.admin;

import cn.itcast.core.controller.BaseController;
import cn.itcast.core.service.product.BrandService;
import cn.itcast.core.web.pojo.WebParam;
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
public class BrandController extends BaseController{

    @Autowired
    private BrandService brandService;

    @RequestMapping(value = "/brand/list.do")
    @Valid(value = {
            @Params(name = "isDisplay", type = Integer.class, validator = Validators.COMMON.REQUIRED),
            @Params(name = "name", type = String.class,validator = Validators.COMMON.REQUIRED)/*,
            @Params(name = "page", type = Integer.class, validator = Validators.COMMON.REQUIRED),
            @Params(name = "rows", type = Integer.class, validator = Validators.COMMON.REQUIRED)*/
    })
    public String brandList(ModelMap model) {
        WebParam webParam = getWebParam();
        webParam.put("page",1);
        webParam.put("rows",5);
        Pagination list = brandService.getBrandListWithPage(webParam);
        model.addAttribute("pagination",list);
        model.addAttribute("name",webParam.get("name"));
        model.addAttribute("isDisplay",webParam.get("isDisplay"));
        return "brand/list";
    }
}
