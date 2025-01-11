package com.web.wps.v3.service;

import java.util.List;

import com.web.wps.v3.model.UserInfo;

/**
 * 用户信息 -> 详见： <br>
 * <a href="https://solution.wps.cn/docs/callback/user.html">wps web office 用户信息</a>
 */
public interface UserService {
    /**
     * 批量获取用户信息
     *
     * @param userIds 用户id列表 <br>
     *                <a href = "https://solution.wps.cn/docs/callback/user.html#批量获取用户信息">-详见官方文档-</a>
     */
    List<UserInfo> fetchUsers(List<String> userIds);
}
