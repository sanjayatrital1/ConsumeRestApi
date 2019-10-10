package com.practice.com.altrimetrikdemo.bean;

public class ErrorResponse {

    private String code;
    private String message;

    public ErrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorResponse(ErrorCode errorCode) {
        this.code = errorCode.name().toString();
        this.message = errorCode.getMessage();
    }

    public static ErrorResponse from(ErrorCode errorCode) {
        return new ErrorResponse(errorCode);
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
