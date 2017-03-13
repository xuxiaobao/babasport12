package cn.itcast.core.controller.front;

import cn.itcast.core.controller.BaseController;
import cn.itcast.core.service.product.SkuService;
import cn.itcast.core.web.Constants;
import cn.itcast.core.web.pojo.BuyCart;
import cn.itcast.core.web.pojo.BuyItem;
import cn.itcast.core.web.pojo.WebParam;
import cn.itcast.core.web.pojo.WebResultMap;
import cn.itcast.validator.Validators;
import cn.itcast.validator.annotation.Params;
import cn.itcast.validator.annotation.Valid;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by xxb on 2017/3/13.
 */
@Controller
public class CartController extends BaseController{
    @Autowired
    private SkuService skuService;

    @Valid({
            @Params(name = "skuId", type = Integer.class, validator = Validators.COMMON.REQUIRED),
            @Params(name = "amount", type = Integer.class, validator = Validators.COMMON.REQUIRED),
            @Params(name = "buyLimit", type = Integer.class, validator = Validators.COMMON.REQUIRED),
            @Params(name = "productId", type = Integer.class, validator = Validators.COMMON.REQUIRED),
    })
    @RequestMapping(value = "/shopping/addCart.shtml")
    public String addCart(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        WebParam webParam = getWebParam();
        WebResultMap sku = new WebResultMap();
        sku.put("id", webParam.get("skuId"));
        sku.put("skuUpperLimit", webParam.get("buyLimit"));
        BuyItem buyItem = new BuyItem();
        buyItem.setSku(sku);
        buyItem.setAmount((Integer) webParam.get("amount"));
        BuyCart buyCart = null;
        Gson gson = new Gson();
        Cookie[] cookies = request.getCookies();
        if (null != cookies && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (Constants.CART_COOKIE.equals(cookie.getName())) {
                    buyCart = gson.fromJson(cookie.getValue(), BuyCart.class);
                }
            }
        }
        if (null == buyCart) {
            buyCart = new BuyCart();
        }
        buyCart.addItem(buyItem);
        buyCart.setProductId((Integer) webParam.get("productId"));
        Cookie cookie = new Cookie(Constants.CART_COOKIE, gson.toJson(buyCart));
        cookie.setMaxAge(24*60*60);
        cookie.setPath("/");
        response.addCookie(cookie);

        List<BuyItem> items = buyCart.getItems();
        for (BuyItem item : items) {
            String id = item.getSku().get("id").toString();
            if (id.indexOf('.') > 0) {
                id = id.substring(0,id.indexOf('.'));
            }
            WebResultMap s = skuService.getSkuByKey(Integer.parseInt(id));
            item.setSku(s);
        }
        model.addAttribute("buyCart", buyCart);
        return "product/cart";
    }

    @RequestMapping(value = "/shopping/buyCart.shtml")
    public String buyCart() {

        return "product/cart";
    }
}
