package com.desafio.resources.exception;

import javax.net.ssl.SSLEngineResult.Status;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.desafio.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandarError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_EXTENDED;
		StandarError err = new StandarError(System.currentTimeMillis(), Status.values(), "Não encontrado",e.getMessage(), request.getRequestURI());
	    return ResponseEntity.status(status).body(err);
	
	}

}
