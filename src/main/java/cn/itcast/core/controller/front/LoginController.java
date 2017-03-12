package cn.itcast.core.controller.front;

import cn.itcast.common.web.ResponseUtils;
import cn.itcast.core.controller.BaseController;
import cn.itcast.core.service.country.CityService;
import cn.itcast.core.service.country.ProvinceService;
import cn.itcast.core.service.country.TownService;
import cn.itcast.core.service.user.BuyerService;
import cn.itcast.core.web.Constants;
import cn.itcast.core.web.pojo.WebParam;
import cn.itcast.core.web.pojo.WebResultMap;
import cn.itcast.core.web.session.SessionProvider;
import cn.itcast.core.web.util.MD5Utils;
import cn.itcast.validator.Validators;
import cn.itcast.validator.annotation.Params;
import cn.itcast.validator.annotation.Valid;
import com.octo.captcha.service.image.ImageCaptchaService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by xxb on 2017/3/9.
 */
@Controller
public class LoginController extends BaseController{
    @Autowired
    private SessionProvider sessionProvider;
    @Autowired
    private BuyerService buyerService;
    @Autowired
    private ImageCaptchaService imageCaptchaService;
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private CityService cityService;
    @Autowired
    private TownService townService;

    @RequestMapping(value = "/shopping/toLogin.shtml", method = RequestMethod.GET)
    public String toLogin() {
        return "buyer/login";
    }

    @Valid({
            @Params(name = "returnUrl", type = String.class),
            @Params(name = "username", type = String.class, validator = Validators.COMMON.REQUIRED),
            @Params(name = "password", type = String.class, validator = Validators.COMMON.REQUIRED),
            @Params(name = "captcha", type = String.class, validator = Validators.COMMON.REQUIRED),
    })
    @RequestMapping(value = "/shopping/toLogin.shtml", method = RequestMethod.POST)
    public String toLogin(HttpServletRequest request, ModelMap model) {
        WebParam webParam = getWebParam();
        if (webParam.get("captcha") != null) {
            if (imageCaptchaService.validateResponseForID(sessionProvider.getSessionId(request),webParam.get("captcha"))) {
                if (webParam.get("username") != null && webParam.get("password") != null) {
                    WebResultMap buyer = buyerService.getBuyerByKey(webParam);
                    if (null != buyer)   {
                        if (buyer.get("password").toString().equals(MD5Utils.MD5(webParam.get("password").toString()))) {
                            sessionProvider.setAttribute(request, Constants.BUYER_SESSION, buyer);
                            if (null != webParam.get("returnUrl")) {
                                return "redirect:" + webParam.get("returnUrl");
                            } else {
                                return "redirect:/buyer/index.shtml";
                            }
                        } else {
                            model.addAttribute("error", "密码输入错误");
                        }
                    } else {
                        model.addAttribute("error", "用户名输入错误");
                    }
                } else {
                    model.addAttribute("error", "用户名或密码不能为空");
                }
            } else {
                model.addAttribute("error", "验证码输入错误");
            }
        } else {
            model.addAttribute("error", "请输入验证码");
        }

        return "buyer/login";
    }

    @RequestMapping(value = "/buyer/index.shtml")
    public String index() {

        return "buyer/index";
    }

    @RequestMapping(value = "/buyer/profile.shtml")
    public String profile(HttpServletRequest request, ModelMap model) {
        WebParam webParam = getWebParam();
        WebResultMap buyer = (WebResultMap) sessionProvider.getAttribute(request, Constants.BUYER_SESSION);
        /*
        个人信息
         */
        model.addAttribute("buyer", buyer);
        /*
        省市县级联查询
         */
        webParam.put("province", buyer.get("province"));
        webParam.put("provinceLike", false);
        webParam.put("city", buyer.get("city"));
        webParam.put("cityLike", false);

        List<WebResultMap> provinces = provinceService.getProvinceList(webParam);
        model.addAttribute("provinces", provinces);
        List<WebResultMap> citys = cityService.getCityList(webParam);
        model.addAttribute("citys", citys);
        List<WebResultMap> towns = townService.getTownList(webParam);
        model.addAttribute("towns", towns);
        return "buyer/profile";
    }

    @RequestMapping(value = "/buyer/deliver_address.shtml")
    public String address() {

        return "buyer/deliver_address";
    }

    @Valid({
            @Params(name = "province", type = String.class, validator = Validators.COMMON.REQUIRED),
    })
    @RequestMapping(value = "/buyer/city.shtml")
    public void city(HttpServletResponse response) {
        WebParam webParam = getWebParam();
        webParam.put("provinceLike", false);
        List<WebResultMap> list = cityService.getCityList(webParam);
        JSONObject jo = new JSONObject();
        jo.put("citys", list);
        ResponseUtils.renderJson(response, jo.toString());
    }

    @Valid({
            @Params(name = "city", type = String.class, validator = Validators.COMMON.REQUIRED),
    })
    @RequestMapping(value = "/buyer/town.shtml")
    public void town(HttpServletResponse response) {
        WebParam webParam = getWebParam();
        webParam.put("cityLike", false);
        List<WebResultMap> list = townService.getTownList(webParam);
        JSONObject jo = new JSONObject();
        jo.put("towns", list);
        ResponseUtils.renderJson(response, jo.toString());
    }
}
