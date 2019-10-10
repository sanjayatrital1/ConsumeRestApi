package com.practice.restconsumedemo.domain;

/**
 * for customized error code and error message
 */
public class ErrorResponse {

    private String code;
    private String message;

    public ErrorResponse(String code, String message){
        this.message = message;
        this.code = code;
    }
    public ErrorResponse(ErrorCode errorCode){
        this.message = errorCode.getMessage();
        this.code = errorCode.toString();
    }

    public ErrorResponse(ErrorCode errorCode, String message){
        this.code = errorCode.name();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
