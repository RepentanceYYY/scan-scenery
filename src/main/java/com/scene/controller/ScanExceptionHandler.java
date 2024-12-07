package com.scene.controller;

import com.scene.entity.ResultFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ScanExceptionHandler {
    @Autowired
    private ResultFormat resultFormat;

    @ExceptionHandler(RuntimeException.class)
    public Map<String, Object> exceptionHandler() {
        return resultFormat.setFormatByFailed(null, "服务器出现异常");
    }
}
