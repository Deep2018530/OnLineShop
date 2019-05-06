package com.lanqiao.zshop.common.Exception;

/**
 * 商品已存在异常
 */
public class ProductTypeExistException extends Exception{
    public ProductTypeExistException() {
    }

    public ProductTypeExistException(String message) {
        super(message);
    }

    public ProductTypeExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductTypeExistException(Throwable cause) {
        super(cause);
    }
}
