package com.web.wps.v3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.wps.v3.exception.NotImplementException;
import com.web.wps.v3.model.ProviderResponseEntity;
import com.web.wps.v3.model.UserInfo;
import com.web.wps.v3.service.UserService;

import java.util.List;
import java.util.Objects;

/**
 * 用户信息 -> 详见： <br>
 * <a href="https://solution.wps.cn/docs/callback/user.html">wps web office
 * 用户信息</a>
 */
@RestController
@RequestMapping("/v3/3rd/users")
public class UserController extends ProviderBaseController {

	/**
	 * 批量获取用户信息
	 *
	 * @param userIds 用户id列表 <br>
	 *                <a href =
	 *                "https://solution.wps.cn/docs/callback/user.html#批量获取用户信息">-详见官方文档-</a>
	 */
	@GetMapping
	@ProviderJsonApi
	public ProviderResponseEntity<List<UserInfo>> fetchUsers(@RequestParam("user_ids") List<String> userIds) {
		return ProviderResponseEntity.ok(this.getServiceOrThrow().fetchUsers(userIds));
	}

	private UserService userService;

	@Autowired(required = false)
	private void setUserService(UserService userService) {
		this.userService = userService;
	}

	private UserService getServiceOrThrow() {
		if (Objects.isNull(this.userService)) {
			String msg = String.format("request path %s not implement with interface class %s ", getRequestPath(),
					"UserService");
			throw new NotImplementException(msg);
		}
		return this.userService;
	}

}
