package com.heroking.o2o.web.wechat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.heroking.o2o.dto.UserAccessToken;
import com.heroking.o2o.dto.WechatAuthExecution;
import com.heroking.o2o.dto.WechatUser;
import com.heroking.o2o.entity.PersonInfo;
import com.heroking.o2o.entity.WechatAuth;
import com.heroking.o2o.enums.WechatAuthStateEnum;
import com.heroking.o2o.service.PersonInfoService;
import com.heroking.o2o.service.WechatAuthService;
import com.heroking.o2o.util.wechat.WechatUtil;

/**
 * @Author heroking
 * @Date 2019年12月4日 上午9:37:32 类说明 获取关注公众号之后的微信用户信息的接口，如果在微信浏览器里面访问：
 *       https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxe6821e7062f88b7f&redirect_uri=http://116.62.171.66/o2o/wechatlogin/logincheck&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect
 *       则这里可以获取到code，之后再通过code获取到access_token，进而获取到用户信息
 */
@Controller
@RequestMapping("/wechatlogin")
public class WechatLoginController {
	private static Logger log = LoggerFactory.getLogger(WechatLoginController.class);
	// 定义两个常量，如果state为1，则进入前端展示页面；如果state为2，则进入店家管理页面
	private static final String FRONTEND = "1";
	private static final String SHOPEND = "2";

	@Autowired
	private PersonInfoService personInfoService;
	@Autowired
	private WechatAuthService wechatAuthService;

	@RequestMapping(value = "/logincheck", method = { RequestMethod.GET })
	public String doGet(HttpServletRequest request, HttpServletResponse response) {
		log.debug("weixin login get...");
		// 获取微信公众号传输过来的code，通过code可获取access_token，进而获取用户信息
		String code = request.getParameter("code");
		// 这个state可以用来传我们自定义的信息，方便程序调用，这里也可以不用
		String roleType = request.getParameter("state");
		log.debug("weixin login code:" + code);
		WechatUser user = null;
		String openId = null;
		WechatAuth auth = null;
		if (null != code) {
			UserAccessToken token;
			try {
				// 通过code获取access_token
				token = WechatUtil.getUserAccessToken(code);
				log.debug("weixin login token:" + token.toString());
				// 通过token获取accessToken
				String accessToken = token.getAccessToken();
				log.debug("weixin login accessToken:" + accessToken);
				// 通过token获取openId
				openId = token.getOpenId();
				user = WechatUtil.getUserInfo(accessToken, openId);
				log.debug("weixin login user:" + user.toString());
				request.getSession().setAttribute("openId", openId);
				// 判断后台是否已经存在该微信账号
				auth = wechatAuthService.getWechatAuthByOpenId(openId);
			} catch (Exception e) {
				log.error("error in getUserAccessToken or getUserInfo or findByOpenId:" + e.toString());
				e.printStackTrace();
			}
		}
		// 如果auth为空，则创建账户
		if (auth == null) {
			PersonInfo personInfo = WechatUtil.getPersonInfoFromRequest(user);
			auth = new WechatAuth();
			auth.setOpenId(openId);
			if (FRONTEND.equals(roleType)) {
				personInfo.setUserType(1);
			} else {
				personInfo.setUserType(2);
			}
			auth.setPersonInfo(personInfo);
			WechatAuthExecution we = wechatAuthService.register(auth);
			if (we.getState() != WechatAuthStateEnum.SUCCESS.getState()) {
				// 如果创建失败，则返回：既不允许进入前端展示系统，也不允许进入店家管理系统
				return null;
			} else {
				// 设置session
				personInfo = personInfoService.getPersonInfoById(auth.getPersonInfo().getUserId());
				request.getSession().setAttribute("user", personInfo);
			}
		}
		//若用户点击的是前端展示系统页，则进入前端展示系统，否则进入店铺管理系统
		if (FRONTEND.equals(roleType)) {
			return "/frontend/index";
		} else {
			return "/shopadmin/shoplist";
		}
	}
}
