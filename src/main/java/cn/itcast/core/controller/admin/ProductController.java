package cn.itcast.core.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xxb on 2017/2/23.
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @RequestMapping("/list.do")
    public String productList() {

        return "product/list";
    }
}
