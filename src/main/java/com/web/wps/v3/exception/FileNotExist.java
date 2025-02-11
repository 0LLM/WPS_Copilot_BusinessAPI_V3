package com.web.wps.v3.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 文件不存在
 */
@Getter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FileNotExist extends ProviderException {
    private final int code = ErrorCodes.FileNotExist.getCode();

    public FileNotExist() {
        this(ErrorCodes.FileNotExist.name());
    }

    public FileNotExist(String message) {
        super(message);
    }
}
