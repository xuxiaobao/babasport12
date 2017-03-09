package cn.itcast.core.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xxb on 2017/3/9.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/buyer/toLogin.shtml")
    public String toLogin() {
        return "buyer/login";
    }
}
