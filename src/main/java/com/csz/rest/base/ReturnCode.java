package com.csz.rest.base;

public enum ReturnCode {
    RC100(100, "Success"),
    RC500(500, "Runtime exception");

    private final int code;
    private final String message;

    ReturnCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
