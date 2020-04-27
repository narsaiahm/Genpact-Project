package com.example.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class HttpBadRequestException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HttpBadRequestException(Throwable throwable) {
        super(throwable);
    }

    public HttpBadRequestException(String message) {
        super(message);
    }

	public HttpBadRequestException(String string, Exception ex) {
        super(string, ex);
    }
}
