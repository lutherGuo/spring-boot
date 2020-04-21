package com.springboot.demo.exception.handler;

import com.springboot.demo.exception.BaseException;
import com.springboot.demo.tool.JSONResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: demo
 * @description:
 * @author: Luther
 * @create: 2020-04-20 12:52
 */
@RestControllerAdvice
public class BaseExceptionHandler {

    private final Log logger = LogFactory.getLog(getClass());

    @ExceptionHandler(Exception.class)
    public JSONResult baseExceptionHandler(Exception e, HttpServletRequest request){
        String path = request.getRequestURI();
        if (e instanceof BaseException){
            BaseException baseException = (BaseException) e;
            baseException.setPath(path);
            logger.info("baseException===========");
            return new JSONResult(baseException.getStatus(),baseException.getMessage(),baseException.getErrorCode(),baseException.getPath());
        }else {
            return null;
        }
    }
}
