package com.qq.weixin.api.exception;

public class InvalidWechatException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private int code;

	private String errMsg;

	public InvalidWechatException(int code, String message) {
		super(message);
		this.code = code;
		this.errMsg = message;
	}

	public InvalidWechatException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidWechatException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidWechatException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidWechatException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

}
