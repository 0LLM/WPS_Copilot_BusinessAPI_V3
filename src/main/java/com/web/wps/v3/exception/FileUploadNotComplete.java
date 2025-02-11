package com.web.wps.v3.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 文件未正确上传，例如保存文档时
 */
@Getter
@ResponseStatus(HttpStatus.FORBIDDEN)
public class FileUploadNotComplete extends ProviderException {
    private final int code = ErrorCodes.FileUploadNotComplete.getCode();

    public FileUploadNotComplete() {
        this(ErrorCodes.FileUploadNotComplete.name());
    }

    public FileUploadNotComplete(String message) {
        super(message);
    }
}
