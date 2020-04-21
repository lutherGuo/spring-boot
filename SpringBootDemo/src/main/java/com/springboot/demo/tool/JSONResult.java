package com.springboot.demo.tool;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;

/**
 * @Created By ShenXi
 * @Created On 2019/9/15 15:03
 * @ClassName : JSONResult
 * @Description :
 */
public class JSONResult<T> extends ResponseEntity<Message> {


    public JSONResult(HttpStatus status) {
        super(status);
    }

    /*public JSONResult(String status, String message, String errorCode, String uri) {
        super(Message.custom(status, message, errorCode, uri), Message.num2HttpStatus(status));
    }*/

    public JSONResult(String status, String message, String errorCode, String path) {
        super( Message.custom(status, message, errorCode, path), Message.num2HttpStatus(status));
    }

    public JSONResult(String status, String msg) {
        super(Message.custom(status, msg), Message.num2HttpStatus(status));
    }

    public JSONResult(String status, String msg, T data) {
        super(Message.custom(status, msg, data), Message.num2HttpStatus(status));
    }


    public static  JSONResult success() {
        return new JSONResult("200", "成功");
    }

    public static <T> JSONResult<T> failed(T data) {
        return new JSONResult("422", "失败", data);
    }

    public static JSONResult failMsg(String msg) {
        return new JSONResult("422", msg);
    }

    public static <T> JSONResult<T> custom(String code, String msg, T data) {
        return new JSONResult(code, msg, data);
    }
}

class Message<T> {


    Date timestamp = new Date();
    String status;
    String errorCode;
    //向前端返回的内容
    String message;

    String path;


    T data;

    public Message() {
    }

    public Message(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public Message(String status, String message, T data) {
        this(status, message);
        this.data = data;
    }

    public Message(String status, String message, String errorCode) {
        this(status, message);
        this.errorCode = errorCode;
    }

    public Message(String status, String message, String errorCode, String path) {
        this(status, message, errorCode);
        this.path = path;
    }

    public Message(String status, String message, String errorCode, T data) {
        this(status, message, errorCode);
        this.data = data;
    }

    public static <T> Message custom(String status, String message, T data) {
        return new Message(status, message, data);
    }

    public static <T> Message<T> custom(String status, String message, String errorCode, T data) {
        return new Message(status, message, errorCode, data);
    }

    public static  Message custom(String status, String message, String errorCode, String path) {
        return new Message(status, message, errorCode, path);
    }

    public static Message custom(String status, String message) {
        //return custom(status, message,null);
        return new Message(status, message, null);
    }

    public static HttpStatus num2HttpStatus(String code) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        for (HttpStatus httpStatus : HttpStatus.values()) {
            boolean b = Integer.parseInt(code) == httpStatus.value();
            if (b) {
                return httpStatus;
            }
        }
        return status;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }





}
