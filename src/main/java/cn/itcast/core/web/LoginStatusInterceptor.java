package cn.itcast.core.web;

import cn.itcast.core.web.pojo.WebResultMap;
import cn.itcast.core.web.session.SessionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xxb on 2017/3/10.
 */
public class LoginStatusInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private SessionProvider sessionProvider;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        boolean flag = false;
        WebResultMap buyer = (WebResultMap) sessionProvider.getAttribute(request, Constants.BUYER_SESSION);
        if (buyer != null) {
            flag = true;
        }
        request.setAttribute("isLogin", flag);
        return true;
    }
}
