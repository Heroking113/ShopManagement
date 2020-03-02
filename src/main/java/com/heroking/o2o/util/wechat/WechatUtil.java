package com.heroking.o2o.util.wechat;

import java.io.BufferedReader;

/**
* @Author heroking
* @Date 2019年12月4日 上午10:17:22
* 类说明
* 获取UserAccessToken实体类
*/

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.heroking.o2o.dto.UserAccessToken;
import com.heroking.o2o.dto.WechatUser;
import com.heroking.o2o.entity.PersonInfo;

public class WechatUtil {
	private static Logger log = LoggerFactory.getLogger(WechatUtil.class);

	/**
	 * @param code
	 * @return
	 * @throws IOException
	 */
	public static UserAccessToken getUserAccessToken(String code) throws IOException {
		// 测试号信息里的appId
		String appId = "wxe6821e7062f88b7f";
		log.debug("appId:" + appId);
		// 测试号信息里的appsecret
		String appsecret = "8c440850a4abd5f14e97e45633bdd8f5";
		log.debug("secret:" + appsecret);
		// 根据传入的code，拼接出访问微信定义好的接口的url
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appId + "&secret=" + appsecret
				+ "&code=" + code + "&grant_type=authorization_code";
		// 向相应的url发送请求获取token_json字符串
		String tokenStr = httpsRequest(url, "GET", null);
		log.debug("userAccessToken:" + tokenStr);
		UserAccessToken token = new UserAccessToken();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			// 将json字符串转换成相应对象
			token = objectMapper.readValue(tokenStr, UserAccessToken.class);
		} catch (JsonParseException e) {
			log.error("获取用户accessToken失败:" + e.getMessage());
			e.printStackTrace();
		} catch (JsonMappingException e) {
			log.error("获取用户accessToken失败：" + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			log.error("获取用户accessToken失败：" + e.getMessage());
			e.printStackTrace();
		}
		if (token == null) {
			log.error("获取用户accessToken失败！");
			return null;
		}
		return token;
	}

	public static WechatUser getUserInfo(String accessToken, String openId) {
		String requestUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=" + accessToken + "&openid=" + openId
				+ "&lang=zh_CN";
		WechatUser userInfo = new WechatUser();
		ObjectMapper objectMapper = new ObjectMapper();
		String userInfos = httpsRequest(requestUrl, "GET", null);
		log.debug("userInfos:" + userInfos);
		try {
			userInfo = objectMapper.readValue(userInfos, WechatUser.class);
		} catch (JsonParseException e) {
			log.error("获取用户信息失败:" + e.getMessage());
			e.printStackTrace();
		} catch (JsonMappingException e) {
			log.error("获取用户信息失败：" + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			log.error("获取用户信息失败：" + e.getMessage());
			e.printStackTrace();
		}
		if (userInfo == null) {
			log.error("获取用户信息失败！");
			return null;
		}
		return userInfo;
	}

	/**
	 * 将WechatUser里面的信息 转换成PersonInfo的信息并返回PersonInfo
	 * 
	 * @param user
	 * @return
	 */
	public static PersonInfo getPersonInfoFromRequest(WechatUser user) {
		PersonInfo personInfo = new PersonInfo();
		personInfo.setName(user.getNickName());
		personInfo.setGender(user.getSex() + "");
		personInfo.setProfileImg(user.getHeadimgurl());
		personInfo.setEnableStatus(1);
		return personInfo;
	}

	/**
	 * 发起https请求并获取结果
	 * 
	 * @param requestUrl：请求地址
	 * @param requestMethod：请求方式（GET，POST）
	 * @param outputStr：提交的数据
	 * @return json字符串
	 */
	public static String httpsRequest(String requestUrl, String requestMethod, String outputStr) {
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式
			httpUrlConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod)) {
				httpUrlConn.connect();
			}

			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			log.debug("https buffer:" + buffer.toString());
		} catch (ConnectException e) {
			log.error("Weixin server connection timed out.");
		} catch (Exception e) {
			log.error("https request error:{}", e);
		}

		return buffer.toString();
	}
}
