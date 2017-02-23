package cn.itcast.core.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 模块身体加载
 * Created by xxb on 2017/2/23.
 */
@Controller
@RequestMapping("/control")
public class FrameController {

    @RequestMapping("/frame/product_main.do")
    public String productMain(HttpServletRequest request) {

        return "frame/product_main";
    }

    @RequestMapping("/frame/order_main.do")
    public String orderMain(HttpServletRequest request) {

        return "frame/order_main";
    }

    @RequestMapping("/frame/product_left.do")
    public String productLeft(HttpServletRequest request) {

        return "frame/product_left";
    }

    @RequestMapping("/frame/order_left.do")
    public String orderLeft(HttpServletRequest request) {

        return "frame/order_left";
    }
}
