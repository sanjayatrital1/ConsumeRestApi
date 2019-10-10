package com.practice.com.altrimetrikdemo.bean;

public enum ErrorCode {
    BAD_REQUEST("Request parameter is not valid"),
    METHOD_NOT_SUPPORTED("This method is not supported"),
    COUNTRY_NOT_FOUND("No specified country exist"),
    SERVER_ERROR("Server error");

    private final String message;

    private ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
