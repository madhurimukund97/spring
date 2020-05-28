package com.example.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus()
public class NoCheckoutInProgressException extends RuntimeException {
//	private static final long serialVersionUID = 1L;
//	public NoCheckoutInProgressException(String string) {
//		// TODO Auto-generated constructor stub
//		super(string);
//	}
}
