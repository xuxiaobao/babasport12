package cn.itcast.core.controller.front;

import cn.itcast.core.controller.BaseController;
import cn.itcast.core.service.product.SkuService;
import cn.itcast.core.web.Constants;
import cn.itcast.core.web.pojo.*;
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
        Sku sku = new Sku();
        sku.setId((Integer) webParam.get("skuId"));
        sku.setSkuUpperLimit((Integer) webParam.get("buyLimit"));
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
            Integer id = item.getSku().getId();
            Sku s = skuService.getSkuByKey(id);
            item.setSku(s);
        }
        model.addAttribute("buyCart", buyCart);
        return "product/cart";
    }

    @RequestMapping(value = "/shopping/cart.shtml")
    public String getCart(HttpServletRequest request, ModelMap model) {
        BuyCart buyCart = null;
        Cookie[] cookies = request.getCookies();
        Gson gson = new Gson();
        if (null != cookies && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (Constants.CART_COOKIE.equals(cookie.getName())) {
                    buyCart = gson.fromJson(cookie.getValue(), BuyCart.class);
                }
            }
        }
        if (null != buyCart) {
            for (BuyItem item : buyCart.getItems()) {
                Integer id = item.getSku().getId();
                Sku s = skuService.getSkuByKey(id);
                item.setSku(s);
            }
        }
        model.addAttribute("buyCart", buyCart);
        return "product/cart";
    }

    @RequestMapping(value = "/shopping/clearCart.shtml")
    public String buyCart(HttpServletRequest request, HttpServletResponse response) {

        Cookie cookie = new Cookie(Constants.CART_COOKIE, null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:/shopping/cart.shtml";
    }
}
