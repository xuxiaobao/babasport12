package cn.itcast.core.web.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

/**
 * 本地session
 * Created by xxb on 2017/3/9.
 */
public class HttpSessionProvider implements SessionProvider {
    public void setAttribute(HttpServletRequest request, String name, Serializable value) {
        HttpSession session = request.getSession();
        session.setAttribute(name, value);
    }

    public Serializable getAttribute(HttpServletRequest request, String name) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            return (Serializable) session.getAttribute(name);
        }
        return null;
    }

    public void logOut(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }

    public String getSessionId(HttpServletRequest request) {
        /**
         * 获取url中的sessionID
         * http://localhost:8080/index.do?JESSIONID=ewreqewrsef12321423
         */
        return request.getSession().getId();
    }
}
