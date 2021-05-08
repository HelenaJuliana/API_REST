package com.desafio.services.exception;

public class ObjectNotFoundExption extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public  ObjectNotFoundExption(String msg) {
		super(msg);
	}

}
