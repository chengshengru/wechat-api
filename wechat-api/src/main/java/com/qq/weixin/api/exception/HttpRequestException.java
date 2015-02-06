package com.qq.weixin.api.exception;

/**
 * 网络异常
 * 
 * @author chengshengru
 *
 */
public class HttpRequestException extends Exception {

	private static final long serialVersionUID = 1L;

	private int code;

	private String errorMsg;

	public HttpRequestException() {
		super();
	}

	public HttpRequestException(int code, String message) {
		super(message);
		this.code = code;
		this.errorMsg = message;
	}

	public HttpRequestException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public HttpRequestException(String message) {
		super(message);
	}

	public HttpRequestException(Throwable cause) {
		super(cause);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
