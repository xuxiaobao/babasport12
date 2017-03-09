package cn.itcast.core.web.session;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * Created by xxb on 2017/3/9.
 */
public interface SessionProvider {
    /**
     * 往session中设置值
     * @param request
     * @param name
     * @param value
     */
    public void setAttribute(HttpServletRequest request, String name, Serializable value);

    /**
     * 从session中获取值
     * @param request
     * @param name
     * @return
     */
    public Serializable getAttribute(HttpServletRequest request, String name);

    /**
     * 退出登陆
     * @param request
     */
    public void logOut(HttpServletRequest request);

    /**
     * 获取sessionID
     * @param request
     * @return
     */
    public String getSessionId(HttpServletRequest request);
}
