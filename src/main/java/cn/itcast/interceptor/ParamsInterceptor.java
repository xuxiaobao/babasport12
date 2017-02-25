package cn.itcast.interceptor;

import cn.itcast.core.controller.BaseController;
import cn.itcast.core.web.pojo.WebParam;
import cn.itcast.core.web.util.DateUtil;
import cn.itcast.validator.ValidatorFactory;
import cn.itcast.validator.annotation.Params;
import cn.itcast.validator.annotation.Valid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ParamsInterceptor extends HandlerInterceptorAdapter{
	private static final Set<Class<?>> SIMPLE_TYPES = new HashSet<Class<?>>();
	static{
		SIMPLE_TYPES.add(Integer.class);
		SIMPLE_TYPES.add(Long.class);
		SIMPLE_TYPES.add(Double.class);
		SIMPLE_TYPES.add(Boolean.class);
		SIMPLE_TYPES.add(String.class);
		SIMPLE_TYPES.add(Date.class);
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			if (handler instanceof HandlerMethod) {
				Valid valid = ((HandlerMethod)handler).getMethodAnnotation(Valid.class);
				WebParam webParam = new WebParam();
				if (null != valid) {
					for (Params params : valid.value()) {
						if (!processParamsAnnotation(webParam, params, request)) {
							return false;
						}
					}
				}
				
				if (((HandlerMethod)handler).getBean() instanceof BaseController) {

					((BaseController)((HandlerMethod)handler).getBean()).setWebParam(webParam);
				}
			}
		
		return super.preHandle(request, response, handler);
	}

	private boolean processParamsAnnotation(WebParam webParam, Params params, HttpServletRequest request) {
		if(SIMPLE_TYPES.contains(params.type())) {
			webParam.put(params.name(), parseSimpleType(params.type(),request.getParameter(params.name())));
		}else if (Set.class == params.type()){
			if (SIMPLE_TYPES.contains(params.elementType())) {
				String[] values = request.getParameterValues(params.name());
				if (values == null) {
					webParam.put(params.name(), null);
				}else {
					Set<Object> set = new HashSet<Object>();
					for (String value : values) {
						set.add(parseSimpleType(params.elementType(), value));
					}
					webParam.put(params.name(), set);
				}
			}else {
				throw new RuntimeException(request.getServletPath()+"-Not valid validation type " + params.elementType());
			}
		}else {
			throw new RuntimeException(request.getServletPath()+"-Not valid validation type " + params.type());
		}
		
		if (!ValidatorFactory.validate(webParam.get(params.name()),params)) {
			throw new RuntimeException("url:"+request.getServletPath()+"-" + params.name() + " is invalid!");
		}
		return true;
	}

	private Object parseSimpleType(Class<?> type, String value) {
		if (StringUtils.isBlank(value)) {
			return null;
		}
		String v = value.trim();
		if (StringUtils.isBlank(value)) {
			return null;
		}
		if (String.class == type) {
			return v;
		}
		if (Integer.class == type) {
			try {
				return Integer.parseInt(v);
			} catch (NumberFormatException e) {
				return null;
			}
		}
		if (Long.class == type) {
			try {
				return Long.parseLong(v);
			} catch (NumberFormatException e) {
				return null;
			}
		}
		if (Double.class == type) {
			try {
				return Double.parseDouble(v);
			} catch (NumberFormatException e) {
				return null;
			}
		}
		if (Boolean.class == type) {
			return Boolean.parseBoolean(v);
		}
		if (Date.class == type) {
			if (v.length() != DateUtil.DEFAULT_DATE_FORMAT.length()) {
				return null;
			}else {
				try {
					return new SimpleDateFormat(DateUtil.DEFAULT_DATE_FORMAT).parse(v);
				} catch (ParseException e) {
					return null;
				}
			}
		}
		return null;
	}

}
