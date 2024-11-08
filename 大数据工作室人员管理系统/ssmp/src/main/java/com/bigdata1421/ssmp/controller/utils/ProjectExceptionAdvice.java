package com.bigdata1421.ssmp.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//作为 spring mvc 的异常处理器
@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler
    public Result doException(Exception ex){
        //记录日志
        //通知运维
        //通知开发
        ex.printStackTrace();
        return new Result(  "请检查操作是否正确");
    }

}
