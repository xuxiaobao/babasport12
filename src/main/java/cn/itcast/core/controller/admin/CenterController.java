package cn.itcast.core.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xxb on 2017/2/23.
 */
@Controller
@RequestMapping("/control")
public class CenterController {

    @RequestMapping("/index.do")
    public String index(HttpServletRequest request) {

        return "index";
    }

    @RequestMapping("/top.do")
    public String top(HttpServletRequest request) {

        return "top";
    }

    @RequestMapping("/main.do")
    public String main(HttpServletRequest request) {

        return "main";
    }

    @RequestMapping("/left.do")
    public String left(HttpServletRequest request) {

        return "left";
    }

    @RequestMapping("/right.do")
    public String right(HttpServletRequest request) {
        return "right";
    }

}
