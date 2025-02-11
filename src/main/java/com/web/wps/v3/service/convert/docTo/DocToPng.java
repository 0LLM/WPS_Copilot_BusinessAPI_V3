package com.web.wps.v3.service.convert.docTo;

import com.web.wps.v3.exception.InvalidArgument;
import com.web.wps.v3.model.convert.ConvertResponse;
import com.web.wps.v3.model.convert.DocToImgRequest;
import com.web.wps.v3.util.ConvertUtils;
import com.web.wps.v3.util.FileUtils;

/**
 * 文档转换成 png 图片  -> 详见： <br>
 * <a href="https://solution.wps.cn/docs/convert/to-png.html">wps web office 官方文档-转为PNG</a>
 */
public class DocToPng {

    /**
     * 文档转png服务 -> 详见： <br>
     * <a href="https://solution.wps.cn/docs/convert/to-png.html">wps web office 官方文档-转为PNG</a>
     * <br>
     * -> 这里传递的是请求对象{@link DocToImgRequest}
     * <br>
     * 返回：{@link ConvertResponse}
     */
    public static ConvertResponse convert(DocToImgRequest r) {
        checkUrl(r.getUrl());
        String uri = "/api/developer/v1/office/convert/to/png";
        return ConvertUtils.post(uri, r, ConvertResponse.class);
    }

    /**
     * 文档转png服务 -> 详见： <br>
     * <a href="https://solution.wps.cn/docs/convert/to-png.html">wps web office 官方文档-转为PNG</a>
     * <br>
     * -> 这里传递的是文件下载连接，名称不传递可自动获取url上的名称
     * <br>
     * 返回：{@link ConvertResponse}
     */
    public static ConvertResponse convert(String url) {
        return convert(new DocToImgRequest(url));
    }

    /**
     * 文档转png服务 -> 详见： <br>
     * <a href="https://solution.wps.cn/docs/convert/to-png.html">wps web office 官方文档-转为PNG</a>
     * <br>
     * -> 这里传递的是文件下载连接 和 文件名称
     * <br>
     * 返回：{@link ConvertResponse}
     */
    public static ConvertResponse convert(String url, String fileName) {
        return convert(new DocToImgRequest(url, fileName));
    }

    /**
     * 文档转png服务 -> 详见： <br>
     * <a href="https://solution.wps.cn/docs/convert/to-png.html">wps web office 官方文档-转为PNG</a>
     * <br>
     * -> 这里传递的是文件下载连接 、 文件名称 、 文件加密密码（如果存在密码，必须传递）
     * <br>
     * 返回：{@link ConvertResponse}
     */
    public static ConvertResponse convert(String url, String fileName, String password) {
        return convert(new DocToImgRequest(url, fileName, password));
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
