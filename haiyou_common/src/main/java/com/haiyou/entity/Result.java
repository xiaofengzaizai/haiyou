package com.haiyou.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/****
 * @Author:shenkunlin
 * @Description:返回实体Bean
 * @Date 2019/6/13 15:55
 *****/
@ApiModel(description = "Result",value = "Result")
public class Result<T> {


    private String code;//返回码

    @ApiModelProperty(value="提示信息",required = true)
    private String msg;//返回消息
    @ApiModelProperty(value="逻辑数据",required = true)
    private T data;//返回数据

    public Result() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
