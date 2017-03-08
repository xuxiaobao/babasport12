package cn.itcast.core.controller.admin;

import cn.itcast.common.web.ResponseUtils;
import cn.itcast.core.controller.BaseController;
import cn.itcast.core.service.product.SkuService;
import cn.itcast.core.web.pojo.WebParam;
import cn.itcast.core.web.pojo.WebResultMap;
import cn.itcast.validator.Validators;
import cn.itcast.validator.annotation.Params;
import cn.itcast.validator.annotation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @Valid({
            @Params(name = "marketPrice", type = Double.class, validator = Validators.COMMON.REQUIRED),
            @Params(name = "skuPrice", type = Double.class, validator = Validators.COMMON.REQUIRED),
            @Params(name = "stockInventory", type = Integer.class, validator = Validators.COMMON.REQUIRED),
            @Params(name = "skuUpperLimit", type = Integer.class, validator = Validators.COMMON.REQUIRED),
            @Params(name = "deliveFee", type = Double.class, validator = Validators.COMMON.REQUIRED),
            @Params(name = "id", type = Integer.class, validator = Validators.COMMON.REQUIRED),
    })
    @RequestMapping(value = "/sku/update.do")
    public void updateSku(HttpServletResponse response, ModelMap model) {
        WebParam webParam = getWebParam();
        skuService.updateSkuByKey(webParam);
        JSONObject jo = new JSONObject();
        jo.put("message","保存成功");
        ResponseUtils.renderJson(response,jo.toString());
    }

}
