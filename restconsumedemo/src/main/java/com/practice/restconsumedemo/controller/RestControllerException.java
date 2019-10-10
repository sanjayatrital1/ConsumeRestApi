package com.practice.restconsumedemo.controller;
import com.practice.restconsumedemo.domain.ErrorCode;
/**
 *To handle exception thrown by controller class at runtime
 */

public class RestControllerException extends RuntimeException {

    private final int httpCode;
    private ErrorCode errorCode;

    public RestControllerException(ErrorCode errorCode, int httpCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.httpCode = httpCode;
    }

    public RestControllerException(ErrorCode errorCode, int httpCode, Throwable t) {
        super(errorCode.getMessage(), t);
        this.errorCode = errorCode;
        this.httpCode = httpCode;
    }

    public RestControllerException(ErrorCode errorCode, int httpCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.httpCode = httpCode;
    }

    public RestControllerException(ErrorCode errorCode, int httpCode, String message, Throwable t) {
        super(message, t);
        this.errorCode = errorCode;
        this.httpCode = httpCode;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
