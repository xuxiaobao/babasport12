package cn.itcast.core.controller.admin;

import cn.itcast.core.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xxb on 2017/2/23.
 */
@Controller
@RequestMapping("/product")
public class ProductController extends BaseController{

    @RequestMapping("/list.do")
    public String productList() {

        return "product/list";
    }
}
