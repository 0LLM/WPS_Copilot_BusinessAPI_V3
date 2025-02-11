package com.web.wps.v3.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 用户不存在
 */
@Getter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserNotExist extends ProviderException {
    private final int code = ErrorCodes.UserNotExist.getCode();

    public UserNotExist() {
        this(ErrorCodes.UserNotExist.name());
    }

    public UserNotExist(String message) {
        super(message);
    }
}
