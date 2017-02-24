package cn.itcast.core.controller;


import cn.itcast.core.web.pojo.WebParam;

public class BaseController {
	private WebParam webParam;

	public WebParam getWebParam() {
		return webParam;
	}

	public void setWebParam(WebParam webParam) {
		this.webParam = webParam;
	}
}
