package cn.itcast.core.controller.front;

import cn.itcast.core.controller.BaseController;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

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
}
