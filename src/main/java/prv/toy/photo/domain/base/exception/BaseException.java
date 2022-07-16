package prv.toy.photo.domain.base.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class BaseException extends RuntimeException {

	private String errorCode;
	private String message;
	private HttpStatus status;

	public BaseException(String errorCode, String message, HttpStatus status) {
		this.errorCode = errorCode;
		this.message = message;
		this.status = status;
	}

	public BaseException(BaseExceptionCode baseExceptionCode) {
		this.errorCode = baseExceptionCode.getErrorCode();
		this.message = baseExceptionCode.getMessage();
	}

	public BaseException(BaseExceptionCode baseExceptionCode, HttpStatus status) {
		this(baseExceptionCode);
		this.status = status;
	}

	public Map<String, Object> getErrorInfo() {
		Map<String, Object> errorInfo = new HashMap<>();

		errorInfo.put("errorCode", this.errorCode);
		errorInfo.put("message", this.message);
		errorInfo.put("status", this.status);

		return errorInfo;
	}

}
