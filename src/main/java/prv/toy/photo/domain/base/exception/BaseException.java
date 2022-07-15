package prv.toy.photo.domain.base.exception;

import java.util.HashMap;
import java.util.Map;

public class BaseException extends RuntimeException {
	
	private String errorCode;
	private String message;

	public BaseException(String errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}

	public BaseException(BaseExceptionCode baseExceptionCode) {
		this.errorCode = baseExceptionCode.getErrorCode();
		this.message = baseExceptionCode.getMessage();
	}

	public Map<String, Object> getErrorInfo() {
		Map<String, Object> errorInfo = new HashMap<>();

		errorInfo.put("errorCode", this.errorCode);
		errorInfo.put("message", this.message);

		return errorInfo;
	}

}
