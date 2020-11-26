package com.example.demo.utils;


public class Msg {
	// 状态码 1-成功 0-失败
	private int code;


	// 用户要返回给浏览器的数据
	private Object msg = new Object();

	public static Msg success() {
		Msg result = new Msg();
		result.setCode(1);
		return result;
	}

	public static Msg fail() {
		Msg result = new Msg();
		result.setCode(0);
		return result;
	}
	
	public static Msg tokenError() {
		Msg result = new Msg();
		result.setCode(-1);
		return result;
	}
	
	public static Msg unknownError() {
		Msg result = new Msg();
		result.setCode(-2);
		return result;
	}
	
	public static Msg privilegeError() {
		Msg result = new Msg();
		result.setCode(3);
		return result;
	}
	
	public static Msg serviceError() {
		Msg result = new Msg();
		result.setCode(2);
		return result;
	}
	
	public Msg add(Object value) {
		this.msg = value;
		return this;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getMsg() {
		return msg;
	}

	public void setMsg(Object msg) {
		this.msg = msg;
	}



}
