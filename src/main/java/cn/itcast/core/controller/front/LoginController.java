package cn.itcast.core.controller.front;

import cn.itcast.core.controller.BaseController;
import cn.itcast.validator.Validators;
import cn.itcast.validator.annotation.Params;
import cn.itcast.validator.annotation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by xxb on 2017/3/9.
 */
@Controller
public class LoginController extends BaseController{

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
    public String toLogin(ModelMap model) {


        return "buyer/login";
    }
}
