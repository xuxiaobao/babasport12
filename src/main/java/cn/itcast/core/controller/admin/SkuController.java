package cn.itcast.core.controller.admin;

import cn.itcast.core.controller.BaseController;
import cn.itcast.core.service.product.SkuService;
import cn.itcast.core.web.pojo.WebParam;
import cn.itcast.core.web.pojo.WebResultMap;
import cn.itcast.validator.Validators;
import cn.itcast.validator.annotation.Params;
import cn.itcast.validator.annotation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2017/3/7.
 */
@Controller
public class SkuController extends BaseController {
    @Autowired
    private SkuService skuService;
    @Valid({
            @Params(name = "productId", type = Integer.class, validator = Validators.COMMON.REQUIRED),
            @Params(name = "productNo", type = String.class, validator = Validators.COMMON.REQUIRED),
    })
    @RequestMapping(value = "/sku/list.do")
    public String list(ModelMap model) {
        WebParam webParam = getWebParam();
        List<WebResultMap> skuList = skuService.getSkuList(webParam);
        model.addAttribute("skus",skuList);
        model.addAttribute("pams", webParam);
        return "sku/list";
    }

}
