package com.studentpal.parents.controller;

import com.studentpal.parents.exception.AuthenticationFailedException;
import com.studentpal.parents.exception.InvalidParamException;

import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public abstract class BaseController {

  private static final int CODE_MISSING_PARAM = 400;
  private static final int CODE_INVALID_PARAM = 400;
  private static final int CODE_RESOURCE_NOT_FOUND = 404;
  private static final int CODE_AUTHENTICATION_FAILED = 401;

  @ExceptionHandler
  public ResponseWrapper<Void> handleException(MissingServletRequestParameterException ex) {
    return ResponseWrapper.error(CODE_MISSING_PARAM, ex.getMessage());
  }

  @ExceptionHandler
  public ResponseWrapper<Void> handleException(InvalidParamException ex) {
    return ResponseWrapper.error(CODE_INVALID_PARAM, ex.getMessage());
  }

  @ExceptionHandler
  public ResponseWrapper<Void> handleException(AuthenticationFailedException ex) {
    return ResponseWrapper.error(CODE_AUTHENTICATION_FAILED, "you have to login first");
  }

  public final <T> ResponseWrapper<T> resourceNotFound() {
      return ResponseWrapper.error(CODE_RESOURCE_NOT_FOUND, "resource not found");
  }
}
