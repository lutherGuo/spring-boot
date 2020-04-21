package com.springboot.demo.exception;

/**
 * @program: demo
 * @description:
 * @author: Luther
 * @create: 2020-04-20 12:48
 */
public class BannerMissException extends BaseException {

    public BannerMissException(){
        super("500","服务器内部错误,不想告诉你","999");
        logger.info("BannerMissException>>>>>>>>>>>>>>>>");
    }
}
