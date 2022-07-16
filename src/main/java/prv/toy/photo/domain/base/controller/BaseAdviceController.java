package prv.toy.photo.domain.base.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import prv.toy.photo.domain.base.exception.BaseException;

@RestControllerAdvice
public class BaseAdviceController {
	
	@ExceptionHandler({BaseException.class})
	public Map<String, Object> baseExceptionHandler(BaseException e) {
		return e.getErrorInfo();
	}
}
