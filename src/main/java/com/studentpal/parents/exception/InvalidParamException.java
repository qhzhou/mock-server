package com.studentpal.parents.exception;

public class InvalidParamException extends RuntimeException {

    public InvalidParamException(String parameterName) {
        super(parameterName + " is invalid");
    }
}
