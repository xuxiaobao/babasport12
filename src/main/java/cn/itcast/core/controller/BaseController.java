package cn.itcast.core.controller;


import cn.itcast.core.web.pojo.WebParam;

public class BaseController {
	private WebParam webParam;

	public WebParam getWebParam() {
		if (webParam == null) {
			webParam = new WebParam();
		}
		initPagination();
		return webParam;
	}

	public void setWebParam(WebParam webParam) {
		this.webParam = webParam;
	}

	/*
     *设置分页默认参数
     * 默认页号是从1开始
	 */
	private void initPagination() {
		if (webParam.get("pageNo") == null) {
			webParam.put("pageNo",1);
		}
		if (webParam.get("pageSize") == null) {
			webParam.put("pageSize",5);
		}
	}
}
