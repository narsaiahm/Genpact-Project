package com.examples.library.util;


public class ResponseWrapper<T>{
	private String responseTag;
	private T response;
	public String getResponseTag() {
		return responseTag;
	}
	public void setResponseTag(String responseTag) {
		this.responseTag = responseTag;
	}
	public T getResponse() {
		return response;
	}
	public void setResponse(T response) {
		this.response = response;
	}
	
}