package com.web.wps.v3.service;

import com.web.wps.v3.model.DownloadInfo;
import com.web.wps.v3.model.FileInfo;
import com.web.wps.v3.model.UserPermission;

/**
 * 文档预览 -> 详见： <br>
 * <a href="https://solution.wps.cn/docs/callback/preview.html">wps web office 文档预览</a>
 */
public interface PreviewService {

    /**
     * 获取文件信息
     *
     * @param fileId 文件id <br>
     *               <a href="https://solution.wps.cn/docs/callback/preview.html#获取文件信息">-详见官方文档-</a>
     */
    FileInfo fetchFileInfo(String fileId);

    /**
     * 获取下载信息
     *
     * @param fileId 文件id <br>
     *               <a href="https://solution.wps.cn/docs/callback/preview.html#获取文件下载地址">-详见官方文档-</a>
     */
    DownloadInfo fetchDownloadInfo(String fileId);

    /**
     * 获取文档用户权限
     *
     * @param fileId 文件id <br>
     *               <a href="https://solution.wps.cn/docs/callback/preview.html#文档用户权限">-详见官方文档-</a>
     */
    UserPermission fetchUserPermission(String fileId);
}
