package com.practice.com.altrimetrikdemo.controller;

import com.practice.com.altrimetrikdemo.bean.ErrorCode;

public class RestControllerException extends RuntimeException {

    private final int httpCode;
    private ErrorCode errorCode;

    public RestControllerException(ErrorCode errorCode, int httpCode) {
        super();
        this.errorCode = errorCode;
        this.httpCode = httpCode;
    }

    public RestControllerException(ErrorCode errorCode, int httpCode, Throwable t) {
        super(t);
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
