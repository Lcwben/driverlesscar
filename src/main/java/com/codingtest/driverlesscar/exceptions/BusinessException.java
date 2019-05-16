package com.codingtest.driverlesscar.exceptions;

/**
 * 自定义业务异常
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String errorMessage) {
        super(errorMessage);
    }

}
