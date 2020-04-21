package com.springboot.demo.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @program: demo
 * @description:
 * @author: Luther
 * @create: 2020-04-20 12:36
 */

public class BaseException extends RuntimeException {

    protected final Log logger = LogFactory.getLog(getClass());

    private String status;

    private String message;

    private String errorCode;

    private String path;

    public BaseException() {
        this(null, null, null);
    }

    public BaseException(String status, String message, String errorCode) {
        super(message);
        this.status = status;
        this.errorCode = errorCode;
        this.message = message;
        logger.info("BaseException(String status, String message, String errorCode)...............");
    }

    public BaseException(String status, String message, String errorCode, String path){
        this(status, message, errorCode);
        this.path=path;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getPath() {
        return path;
    }
}
