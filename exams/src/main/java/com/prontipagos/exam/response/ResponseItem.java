package com.prontipagos.exam.response;

public class ResponseItem<T> {

	private String message;
	
	private int code;
	
	private T payload;
	
	public ResponseItem() {
		super();
	}
		
	public ResponseItem(String message, int code) {
		super();
		this.message = message;
		this.code = code;
	}

	public ResponseItem(String message, int code, T payload) {
		super();
		this.message = message;
		this.code = code;
		this.payload = payload;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public T getPayload() {
		return payload;
	}

	public void setPayload(T payload) {
		this.payload = payload;
	}
	
	
}
