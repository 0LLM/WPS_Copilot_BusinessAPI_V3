package com.web.wps.v3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.wps.v3.exception.NotImplementException;
import com.web.wps.v3.model.DownloadInfo;
import com.web.wps.v3.model.FileInfo;
import com.web.wps.v3.model.ProviderResponseEntity;
import com.web.wps.v3.model.UserPermission;
import com.web.wps.v3.service.PreviewService;

import java.util.Objects;

/**
 * 文档预览 -> 详见： <br>
 * <a href="https://solution.wps.cn/docs/callback/preview.html">wps web office 文档预览</a>
 */
@RestController
@RequestMapping("/v3/3rd/files")
public class PreviewController extends ProviderBaseController {

    /**
     * 获取文件信息
     *
     * @param fileId 文件id <br>
     *               <a href="https://solution.wps.cn/docs/callback/preview.html#获取文件信息">-详见官方文档-</a>
     */
    @GetMapping("/{file_id}")
    @ProviderJsonApi
    public ProviderResponseEntity<FileInfo> fetchFile(@PathVariable("file_id") final String fileId) {
        return ProviderResponseEntity.ok(this.getServiceOrThrow().fetchFileInfo(fileId));
    }

    /**
     * 获取下载信息
     *
     * @param fileId 文件id <br>
     *               <a href="https://solution.wps.cn/docs/callback/preview.html#获取文件下载地址">-详见官方文档-</a>
     */
    @GetMapping("/{file_id}/download")
    @ProviderJsonApi
    public ProviderResponseEntity<DownloadInfo> fetchDownloadInfo(@PathVariable("file_id") final String fileId) {
        return ProviderResponseEntity.ok(this.getServiceOrThrow().fetchDownloadInfo(fileId));
    }

    /**
     * 获取文档用户权限
     *
     * @param fileId 文件id <br>
     *               <a href="https://solution.wps.cn/docs/callback/preview.html#文档用户权限">-详见官方文档-</a>
     */
    @GetMapping("/{file_id}/permission")
    @ProviderJsonApi
    public ProviderResponseEntity<UserPermission> fetchUserPermission(@PathVariable("file_id") final String fileId) {
        return ProviderResponseEntity.ok(this.getServiceOrThrow().fetchUserPermission(fileId));
    }

    private PreviewService previewService;

    @Autowired(required = false)
    private void setPreviewService(PreviewService previewService) {
        this.previewService = previewService;
    }

    private PreviewService getServiceOrThrow() {
        if (Objects.isNull(this.previewService)) {
            String msg = String.format("request path %s not implement with interface class %s ", getRequestPath(), "PreviewService");
            throw new NotImplementException(msg);
        }
        return this.previewService;
    }
}
