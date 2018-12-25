package com.github.jobjava00.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 글로벌 exception 처리
 * @author jobjava00
 */
@ControllerAdvice
public class ExceptionHandleController {
	@ExceptionHandler(BangsongException.class)
	public ResponseEntity<String> handleException(BangsongException e) {
		return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
	}
}
