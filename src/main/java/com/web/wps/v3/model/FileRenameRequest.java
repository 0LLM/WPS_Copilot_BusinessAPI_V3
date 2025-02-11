package com.web.wps.v3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文件重命名请求
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileRenameRequest {
    private String name;
}

