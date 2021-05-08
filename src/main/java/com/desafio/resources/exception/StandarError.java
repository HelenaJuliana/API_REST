package com.desafio.resources.exception;

import java.io.Serializable;

import javax.net.ssl.SSLEngineResult.Status;

public class StandarError implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
	
	
	public StandarError(long l, Status[] status2, String string, String string2, String string3) {
		
	}

	

	public Long getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}
	
}
