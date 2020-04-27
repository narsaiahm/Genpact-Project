package com.example.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class BookServiceException extends Exception {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookServiceException(Throwable throwable) {
        super(throwable);
    }

    public BookServiceException(String message) {
        super(message);
    }

	public BookServiceException(String string, Exception ex) {
        super(string, ex);
    }
}