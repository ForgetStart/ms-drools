package com.hc360.drools.bean;

public class BaseResult {

	private static BaseResult singleton = new BaseResult();

	private long code;
	private String msg;
	private Object data;

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	private BaseResult(){}

	public static BaseResult getInstance(){
		return singleton;
	}

	public static BaseResult isSuccess(Object data){
		BaseResult baseResult = getInstance();
		baseResult.setCode(100);
		baseResult.setMsg("成功");

		baseResult.setData(data);
		return  baseResult;
	}

	public static BaseResult isSuccess(Object data, String msg){
		BaseResult baseResult = getInstance();
		baseResult.setCode(100);
		baseResult.setMsg(msg);

		baseResult.setData(data);
		return  baseResult;
	}

	public static BaseResult isFail(String msg){
		BaseResult baseResult = getInstance();

		baseResult.setCode(200);
		baseResult.setMsg(msg);
		return baseResult;
	}


	public static BaseResult illegalParam(String msg){
		BaseResult baseResult = getInstance();

		baseResult.setCode(300);
		baseResult.setMsg(msg);

		return baseResult;
	}

}
