package com.studentpal.parents.controller;

import lombok.Data;

@Data
public class ResponseWrapper<T> {

    private int code;
    private String msg;
    private T data;

    public static <T> ResponseWrapper<T> succeed(T data) {
        ResponseWrapper<T> result = new ResponseWrapper<>();
        result.code = 0;
        result.msg = "succeed";
        result.data = data;
        return result;
    }

    public static <T> ResponseWrapper<T> error(int code, String msg) {
        ResponseWrapper<T> result = new ResponseWrapper<>();
        result.code = code;
        result.msg = msg;
        return result;
    }
}
