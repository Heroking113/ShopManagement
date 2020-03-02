package com.heroking.o2o.web.local;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author heroking
 * @Date 2019年12月15日 下午8:27:41 类说明
 */
@Controller
@RequestMapping("/local")
public class LocalController {
	/**
	 * 绑定账号页路由
	 * 
	 * @return
	 */
	@RequestMapping(value = "/accountbind", method = RequestMethod.GET)
	private String accountbind() {
		return "/local/accountbind";
	}

	/**
	 * 修改密码页路由
	 * 
	 * @return
	 */
	@RequestMapping(value = "/changepsw", method = RequestMethod.GET)
	private String changepsw() {
		return "/local/changepsw";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	private String login() {
		return "/local/login";
	}
}
