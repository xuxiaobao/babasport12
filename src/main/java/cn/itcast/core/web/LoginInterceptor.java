package cn.itcast.core.web;

import cn.itcast.core.web.pojo.WebResultMap;
import cn.itcast.core.web.session.SessionProvider;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xxb on 2017/3/10.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private SessionProvider sessionProvider;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        WebResultMap buyer = (WebResultMap) sessionProvider.getAttribute(request, Constants.BUYER_SESSION);
        if (null == buyer) {
            String returnUrl = request.getParameter("returnUrl");
            if (StringUtils.isNotBlank(returnUrl)) {
                returnUrl = (new StringBuilder("/shopping/login.shtml?returnUrl=")).append(returnUrl).toString();
            } else {
                returnUrl = "/shopping/login.shtml";
            }
            response.sendRedirect(returnUrl);
            return false;
        }
        return true;
    }
}
