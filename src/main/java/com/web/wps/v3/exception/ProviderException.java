package com.web.wps.v3.exception;

/**
 * 错误信息抽象层
 */
public abstract class ProviderException extends RuntimeException {
    public ProviderException(String message) {
        super(message);
    }

    public abstract int getCode();
}
