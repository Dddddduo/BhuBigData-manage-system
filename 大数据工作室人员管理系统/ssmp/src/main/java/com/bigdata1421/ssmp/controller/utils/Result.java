package com.bigdata1421.ssmp.controller.utils;

import lombok.Data;

@Data
public class Result {
    private Boolean flag;
    private Object data;
    private String msg;
    public Result(Boolean flag){
        this.flag=flag;
    }
    public Result(Boolean flag,Object data){
        this.flag=flag;
        this.data=data;
    }

    public Result(String msg){
        this.flag=false;
        this.msg=msg;
    }

}
