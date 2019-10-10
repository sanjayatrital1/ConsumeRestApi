package com.practice.restconsumedemo.domain;

/**
 * For customized error code
 */

public enum ErrorCode {

    BAD_REQUEST("Request Parameter is not valid"),
    METHOD_NOT_SUPPORTED("This method is not supported"),
    COUNTRY_NOT_FOUND("No specified country exist"),
    SERVER_ERROR("Server Error");

    private final String message;

    public String getMessage() {
        return message;
    }
    private ErrorCode(String message){
        this.message = message;
    }
}
