package com.haiyou.framework.exception;

import com.haiyou.entity.Result;
import com.haiyou.entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*****
 * @Author: shenzhen-itheima
 * @Date: 2019/7/26 12:55
 * @Description: com.changgou.framework.exception
 ****/


@ControllerAdvice
public class BaseExceptionHandler {

    /****
     * 异常处理  @ExceptionHandler
     *           value = Exception.class:指定要处理的异常类型
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Result error(Exception e){
        e.printStackTrace();
        return new Result("error","失败",e.getMessage());
    }
}
