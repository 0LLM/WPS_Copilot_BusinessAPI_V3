package com.web.wps.v3.service.convert.docTo;

import com.web.wps.v3.exception.InvalidArgument;
import com.web.wps.v3.model.convert.ConvertResponse;
import com.web.wps.v3.model.convert.DocToTxtRequest;
import com.web.wps.v3.util.ConvertUtils;
import com.web.wps.v3.util.FileUtils;

/**
 * 文档转换成 txt  -> 详见： <br>
 * <a href="https://solution.wps.cn/docs/convert/to-txt.html">wps web office 官方文档</a>
 */
public class DocToTxt {

    /**
     * 文档转TXT服务 -> 详见： <br>
     * <a href="https://solution.wps.cn/docs/convert/to-txt.html">wps web office 官方文档</a>
     * <br>
     * -> 这里传递的是请求对象{@link DocToTxtRequest}
     * <br>
     * 返回：{@link ConvertResponse}
     */
    public static ConvertResponse convert(DocToTxtRequest r) {
        checkUrl(r.getUrl());
        String uri = "/api/developer/v1/office/convert/to/txt";
        return ConvertUtils.post(uri, r, ConvertResponse.class);
    }

    /**
     * 文档转TXT服务 -> 详见： <br>
     * <a href="https://solution.wps.cn/docs/convert/to-txt.html">wps web office 官方文档</a>
     * <br>
     * -> 这里传递的是文件下载连接，名称不传递可自动获取url上的名称
     * <br>
     * 返回：{@link ConvertResponse}
     */
    public static ConvertResponse convert(String url) {
        return convert(new DocToTxtRequest(url));
    }

    /**
     * 文档转TXT服务 -> 详见： <br>
     * <a href="https://solution.wps.cn/docs/convert/to-txt.html">wps web office 官方文档</a>
     * <br>
     * -> 这里传递的是文件下载连接 和 文件名称
     * <br>
     * 返回：{@link ConvertResponse}
     */
    public static ConvertResponse convert(String url, String fileName) {
        return convert(new DocToTxtRequest(url, fileName));
    }

    /**
     * 文档转TXT服务 -> 详见： <br>
     * <a href="https://solution.wps.cn/docs/convert/to-txt.html">wps web office 官方文档</a>
     * <br>
     * -> 这里传递的是文件下载连接 、 文件名称 、 文件加密密码（如果存在密码，必须传递）
     * <br>
     * 返回：{@link ConvertResponse}
     */
    public static ConvertResponse convert(String url, String fileName, String password) {
        return convert(new DocToTxtRequest(url, fileName, password));
    }

    /**
     * 校验文件url是否为支持的文档类型
     *
     * @param url 文件下载地址
     */
    private static void checkUrl(String url) {
        if (url == null || url.isEmpty()) throw new InvalidArgument();
        String fileType = FileUtils.suffix(url);
        FileUtils.typeMatchCheck(FileUtils.documentConvertTypes, fileType);
    }
}
